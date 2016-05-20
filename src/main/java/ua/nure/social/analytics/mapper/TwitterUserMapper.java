package ua.nure.social.analytics.mapper;

import twitter4j.User;
import ua.nure.social.configuration.TwitterUserMapperConfiguration;
import ua.nure.social.exception.InvalidMapper;
import ua.nure.social.exception.MapperException;
import ua.nure.social.model.node.SocialNode;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class TwitterUserMapper implements Mapper<SocialNode> {

    private List<String> ignoredFields = Collections.emptyList();

    public TwitterUserMapper() {
    }

    public TwitterUserMapper(TwitterUserMapperConfiguration configuration) {
        this.ignoredFields = configuration.getIgnoredFields();
    }

    public SocialNode map(Object object) {
        checkUser(object);
        SocialNode node = new SocialNode();
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        node.setId(((User)object).getScreenName());
        for(Field currentField : fields) {
            extractProperty(object, node, currentField);
        }
        return node;
    }

    private void extractProperty(Object object, SocialNode node, Field currentField) {
        try {
            String fieldName = currentField.getName();
            if(!ignoredFields.contains(fieldName)) {
                boolean wasAccessible = currentField.isAccessible();
                access(currentField, wasAccessible);
                node.setProperty(fieldName, currentField.get(object));
                access(currentField, wasAccessible);
            }
        } catch (IllegalAccessException e) {
            throw new MapperException("Error mapping the object: " + object, e);
        }
    }

    private void access(Field currentField, boolean wasAccessible) {
        if(!currentField.isAccessible()) {
            currentField.setAccessible(true);
        } else if (!wasAccessible) {
            currentField.setAccessible(false);
        }
    }

    private void checkUser(Object object) {
        if(!(object instanceof User)) {
            throw new InvalidMapper("Inapplicable mapper for object: " + object);
        }
    }

}