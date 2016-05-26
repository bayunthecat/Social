package ua.nure.social.analytics.builder;

import org.springframework.beans.factory.annotation.Autowired;
import ua.nure.social.analytics.builder.api.SocialGraphBuilder;
import ua.nure.social.analytics.builder.tools.FieldExtractor;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.client.SocialUserClient;
import ua.nure.social.repository.TwitterUserRepository;
import ua.nure.social.util.Const;

public class DepthSocialGraphBuilder implements SocialGraphBuilder {

    @Autowired
    private SocialUserClient<SocialNode> client;

    @Autowired
    private FieldExtractor extractor;

    @Autowired
    private TwitterUserRepository repository;

    //TODO to config
    private int depth = Const.App.DEFAULT_DEPTH;

    public SocialNode build(Object... params) {
        SocialNode node = client.getUserById(extractScreenName(params));
        return null;
    }

    private void fetchFollowers(SocialNode node) {
        Object id = extractor.extract(node);
        client.getFollowers(id, 200);
    }

    private String extractScreenName(Object... params) {
        if(params.length == 0) {
            return "";
        }
        return (String) params[0];
    }
}