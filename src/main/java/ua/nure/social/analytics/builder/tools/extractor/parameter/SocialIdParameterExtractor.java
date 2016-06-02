package ua.nure.social.analytics.builder.tools.extractor.parameter;

import java.util.Map;

public class SocialIdParameterExtractor implements ParameterExtractor {

    private String parameterName;

    @Override
    public Object getParameter(Map<String, Object> map) {
        return map.get(parameterName);
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }
}
