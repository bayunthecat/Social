package ua.nure.social.net.client;

import org.apache.log4j.Logger;
import twitter4j.RateLimitStatus;
import twitter4j.TwitterException;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.tools.cursor.PageCursor;
import ua.nure.social.net.tools.wrapper.PagableResponseWrapper;

import java.util.Map;

public class SafeTwitterUserClient extends TwitterUserClient {

    private static final Logger LOG = Logger.getLogger(SafeTwitterUserClient.class);

    @Override
    public SocialNode getUserById(Object screenName) {
        return super.getUserById(screenName);
    }

    @Override
    public PagableResponseWrapper<SocialNode> getFollowers(Object screenName, PageCursor<Long> cursor, int count) {
        return super.getFollowers(screenName, cursor, count);
    }

    @Override
    public PagableResponseWrapper<SocialNode> getFriends(Object screenName, PageCursor<Long> cursor, int count) {
        return super.getFriends(screenName, cursor, count);
    }

    private Map<String, RateLimitStatus> getRateLimits() {
        Map<String, RateLimitStatus> rateLimitStatus = null;
        try {
            rateLimitStatus = twitter.getRateLimitStatus();
        } catch (TwitterException e) {
            LOG.error("Failed to get rate limit ==> " + e.getMessage());
        }
        return rateLimitStatus;
    }
}
