package ua.nure.social.analytics.builder.api;

import ua.nure.social.model.node.SocialNode;

import java.util.Map;

public interface SocialGraphBuilder {

    SocialNode build(Map<String, Object> params);

}