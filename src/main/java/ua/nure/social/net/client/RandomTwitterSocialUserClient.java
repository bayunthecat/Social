package ua.nure.social.net.client;

import org.springframework.beans.factory.annotation.Autowired;
import ua.nure.social.model.node.SimpleTwitterUser;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.configuration.RandomTwitterClientConfigurator;
import ua.nure.social.net.tools.wrapper.PagableResponseWrapper;
import ua.nure.social.net.tools.wrapper.PageCursor;
import ua.nure.social.net.tools.wrapper.random.RandomPageCursor;
import ua.nure.social.net.tools.wrapper.twitter.TwitterPagableResponseWrapper;
import ua.nure.social.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomTwitterSocialUserClient implements SocialUserClient<SocialNode, Long>{

    @Autowired
    private RandomGenerator generator;

    @Autowired
    private RandomTwitterClientConfigurator configurator;

    @Override
    public SocialNode getUserById(String id) {
        return getRandomTwitterUser();
    }

    @Override
    public PagableResponseWrapper<SocialNode> getFollowers(Object id, PageCursor cursor ,int count) {
        List<SocialNode> nodes = getSocialNodesList(configurator.getFollowersLower(), configurator.getFollowersHigher());
        return new TwitterPagableResponseWrapper(nodes, cursor);
    }

    @Override
    public PagableResponseWrapper<SocialNode> getFriends(Object id, PageCursor cursor, int count) {
        List<SocialNode> nodes = getSocialNodesList(configurator.getFriendsLower(), configurator.getFriendsHigher());
        return new TwitterPagableResponseWrapper(nodes, cursor);
    }

    private SocialNode getRandomTwitterUser() {
        SimpleTwitterUser node = new SimpleTwitterUser();
        node.setScreenName(generator.generateName(
                configurator.getNameLengthLower(), configurator.getNameLengthHigher()));
        return node;
    }

    private List<SocialNode> getSocialNodesList(int from, int to) {
        List<SocialNode> socialNodes = new ArrayList<>();
        for(int i = 0; i < generator.getInt(from, to); i++) {
            socialNodes.add(getRandomTwitterUser());
        }
        return socialNodes;
    }
}