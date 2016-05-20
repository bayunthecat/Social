package ua.nure.social.analytics.builder.api;

import ua.nure.social.model.node.SocialNode;

public interface SocialGraphBuilder {

    SocialNode build(Object... params);

}