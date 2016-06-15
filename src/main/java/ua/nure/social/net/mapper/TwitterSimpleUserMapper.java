package ua.nure.social.net.mapper;

import twitter4j.User;
import ua.nure.social.exception.InvalidMapper;
import ua.nure.social.model.node.SimpleTwitterUser;

import java.util.Collections;
import java.util.List;

public class TwitterSimpleUserMapper implements Mapper<SimpleTwitterUser> {

    private List<String> ignoredFields = Collections.emptyList();

    public SimpleTwitterUser map(Object object) {
        checkUser(object);
        User twitterUser = (User) object;
        SimpleTwitterUser user = new SimpleTwitterUser();
        user.setScreenName(twitterUser.getScreenName());
        user.setId(user.getId());
        return user;
    }

    private void checkUser(Object object) {
        if (!(object instanceof User)) {
            throw new InvalidMapper("Inapplicable mapper for object: " + object);
        }
    }

}