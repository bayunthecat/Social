package ua.nure.social.net.client;

import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.TwitterException;
import ua.nure.social.analytics.mapper.TwitterSimpleUserMapper;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.tools.ResponseTransformer;
import ua.nure.social.util.Const;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

public class TwitterUserClient implements SocialUserClient<SocialNode> {

    private static Logger LOG = Logger.getLogger(TwitterUserClient.class);

    @Autowired
    @Resource(name = Const.Spring.Components.TWITTER_PAGABLE_TRANSFORMER)
    private ResponseTransformer<PagableResponseList<User>, List<SocialNode>> responseTransformer;

    private Twitter twitter = TwitterFactory.getSingleton();

    @Override
    public SocialNode getUserById(String screenName) {
        SocialNode user = null;
        try {
            user = new TwitterSimpleUserMapper().map(twitter.showUser(screenName));
        } catch (TwitterException e) {
            LOG.error("Failed to fetch user ==> " + screenName, e);
        }
        return user;
    }

    //TODO session for continuous fetching. Both for friends and followers.
    @Override
    public List<SocialNode> getFollowers(Object screenName, int count) {
        try {
            return responseTransformer.transform(twitter.getFollowersList((String) screenName, -1, count));
        } catch (TwitterException e) {
            LOG.error("Failed to fetch followers for user ==> " + screenName, e);
        }
        return Collections.emptyList();
    }

    @Override
    public List<SocialNode> getFriends(Object screenName, int count) {
        try {
            return responseTransformer.transform(twitter.getFollowersList((String) screenName, -1, count));
        } catch (TwitterException e) {
            LOG.error("Failed to fetch friends for user ==> " + screenName, e);
        }
        return Collections.emptyList();
    }
}
