package ua.nure.social.model;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseItem {

    private String id;

    private Map<String, Object> properties;

    public BaseItem() {
        properties = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public <T> T setProperty(String name, T property) {
        properties.put(name, property);
        return property;
    }

    public Object getProperty(String name) {
        return properties.get(name);
    }

    public Object removeProperty(String name) {
        return properties.remove(name);
    }

    public String[] getPropertiesNames() {
        String[] propertiesNames = new String[properties.size()];
        int i = 0;
        for(String key : properties.keySet()) {
            propertiesNames[i++] = key;
        }
        return propertiesNames;
    }

    @Override
    public String toString() {
        return "BaseItem{" +
                "id='" + id + '\'' +
                ", properties=" + properties +
                '}';
    }
}
