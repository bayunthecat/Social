package ua.nure.social.analytics.builder;

import ua.nure.social.analytics.builder.api.SocialGraphBuilder;
import ua.nure.social.analytics.builder.tools.extractor.field.FieldExtractor;
import ua.nure.social.analytics.builder.tools.extractor.parameter.ParameterExtractor;
import ua.nure.social.model.node.SimpleTwitterUser;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.client.SocialUserClient;
import ua.nure.social.net.tools.cursor.PageCursorFactory;
import ua.nure.social.net.tools.wrapper.PagableResponseWrapper;
import ua.nure.social.net.tools.cursor.PageCursor;
import ua.nure.social.repository.NeoSimpleTwitterUserRepository;
import ua.nure.social.util.Const;
import ua.nure.social.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TODO Think of generic approach

@SuppressWarnings({"unchecked", "unused"})
public class DepthSocialGraphBuilder implements SocialGraphBuilder {

    private static final int START_DEPTH = 0;

    private SocialUserClient<SocialNode, Long> client;

    private FieldExtractor extractor;

    private NeoSimpleTwitterUserRepository repository;

    private ParameterExtractor socialIdExtractor;

    private PageCursorFactory pageCursorFactory;

    private int depth = Const.App.DEFAULT_DEPTH;

    private int responseSize = 200;

    public SocialNode build(Map<String, Object> params) {
        Object socialId = socialIdExtractor.getParameter(params);
        SocialNode node = client.getUserById(socialId);
        return buildNode(node, START_DEPTH);
    }

    private SocialNode buildNode(SocialNode node, int currentDepth) {
        fetchFollowers(node, extractor.extract(node), pageCursorFactory.getPageCursor());
        fetchFriends(node, extractor.extract(node), pageCursorFactory.getPageCursor());
        repository.saveNode((SimpleTwitterUser) node);
        if(currentDepth < depth) {
            for(SocialNode socialNode : Utils.getCollectionsAsOne(node.getFollowers(), node.getFriends())) {
                buildNode(socialNode, ++currentDepth);
            }
        }
        return node;
    }

    private List<SocialNode> getAllRelationships(SocialNode node) {
        List<SocialNode> relationships = new ArrayList<>();
        relationships.addAll(node.getFollowers());
        relationships.addAll(node.getFriends());
        return relationships;
    }

    private SocialNode fetchFollowers(SocialNode node, Object socialId ,PageCursor cursor) {
        PagableResponseWrapper<SocialNode> wrapper;
        while (!cursor.isFinished()) {
            wrapper = client.getFollowers(socialId, cursor, responseSize);
            node.addFollowers(wrapper.getResponseList());
            cursor = wrapper.getPageCursor();
        }
        return node;
    }

    private SocialNode fetchFriends(SocialNode node, Object socialId ,PageCursor cursor) {
        PagableResponseWrapper<SocialNode> wrapper;
        while (!cursor.isFinished()) {
            wrapper = client.getFriends(socialId, cursor, responseSize);
            node.addFriends(wrapper.getResponseList());
            cursor = wrapper.getPageCursor();
        }
        return node;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setResponseSize(int responseSize) {
        this.responseSize = responseSize;
    }

    public void setClient(SocialUserClient<SocialNode, Long> client) {
        this.client = client;
    }

    public void setExtractor(FieldExtractor extractor) {
        this.extractor = extractor;
    }

    public void setRepository(NeoSimpleTwitterUserRepository repository) {
        this.repository = repository;
    }

    public void setSocialIdExtractor(ParameterExtractor socialIdExtractor) {
        this.socialIdExtractor = socialIdExtractor;
    }

    public void setPageCursorFactory(PageCursorFactory pageCursorFactory) {
        this.pageCursorFactory = pageCursorFactory;
    }
}