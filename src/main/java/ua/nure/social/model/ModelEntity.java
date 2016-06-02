package ua.nure.social.model;

import org.neo4j.ogm.annotation.GraphId;
import ua.nure.social.util.Const;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.StringJoiner;

public abstract class ModelEntity {

    @GraphId
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(Const.COMMA + Const.WHITESPACE);
        classToString(joiner, this.getClass());
        return Const.CURLY_OPENING_BRACKET + joiner.toString() + Const.CURLY_CLOSING_BRACKET;
    }

    private void classToString(StringJoiner joiner, Class<?> clazz) {
        for(Field field : clazz.getDeclaredFields()) {
            joiner.add(field.getName() + Const.COLON + getString(field));
        }
        if(clazz.getSuperclass() != Object.class) {
            classToString(joiner, clazz.getSuperclass());
        }
    }

    private String getString(Field field) {
        Object fieldValue = accessField(field);
        if(fieldValue instanceof Collection) {
            return String.valueOf(((Collection)accessField(field)).size());
        }
        return fieldValue != null ? fieldValue.toString() : null;
    }

    private Object accessField(Field field) {
        try {
            Object fieldValue;
            if(!field.isAccessible()) {
                field.setAccessible(true);
                fieldValue = field.get(this);
                field.setAccessible(false);
            } else {
                fieldValue = field.get(this);
            }
            return fieldValue;
        } catch (IllegalAccessException exception) {
            return exception.getMessage();
        }
    }

}
