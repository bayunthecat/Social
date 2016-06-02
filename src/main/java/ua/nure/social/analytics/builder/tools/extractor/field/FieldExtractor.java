package ua.nure.social.analytics.builder.tools.extractor.field;

import ua.nure.social.model.node.SocialNode;

public interface FieldExtractor {

    Object extract(SocialNode node);

}
