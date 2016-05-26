package ua.nure.social.analytics.builder.tools;

import ua.nure.social.exception.FieldExtractorException;
import ua.nure.social.model.node.SimpleTwitterUser;
import ua.nure.social.model.node.SocialNode;

public class TwitterSreenNameExtractor implements FieldExtractor {

    @Override
    public Object extract(SocialNode node) {
        SimpleTwitterUser user = checkType(node);
        return user.getScreenName();
    }

    private SimpleTwitterUser checkType(SocialNode node) {
        if(!(node instanceof SimpleTwitterUser)) {
            throw new FieldExtractorException();
        }
        return (SimpleTwitterUser) node;
    }

}
