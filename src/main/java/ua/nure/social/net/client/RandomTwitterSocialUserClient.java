package ua.nure.social.net.client;

import org.springframework.beans.factory.annotation.Autowired;
import ua.nure.social.model.node.SimpleTwitterUser;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.configuration.RandomTwitterClientConfigurator;
import ua.nure.social.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomTwitterSocialUserClient implements SocialUserClient<SocialNode>{

    @Autowired
    private RandomGenerator generator;

    @Autowired
    private RandomTwitterClientConfigurator configurator;

    @Override
    public SocialNode getUserById(String id) {
        return getRandomTwitterUser();
    }

    @Override
    public List<SocialNode> getFollowers(Object id, int count) {
        return getSocialNodesList(configurator.getFollowersLower(), configurator.getFollowersHigher());
    }

    @Override
    public List<SocialNode> getFriends(Object id, int count) {
        return getSocialNodesList(configurator.getFriendsLower(), configurator.getFriendsHigher());
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