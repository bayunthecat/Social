package ua.nure.social.configuration;

import java.util.Collections;
import java.util.List;

public class TwitterUserMapperConfiguration {

    private List<String> ignoredFields = Collections.emptyList();

    public List<String> getIgnoredFields() {
        return ignoredFields;
    }

    public void setIgnoredFields(List<String> ignoredFields) {
        this.ignoredFields = ignoredFields;
    }
}
