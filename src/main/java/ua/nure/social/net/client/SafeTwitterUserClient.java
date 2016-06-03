package ua.nure.social.net.client;

import org.apache.log4j.Logger;
import twitter4j.RateLimitStatus;
import twitter4j.TwitterException;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.tools.cursor.PageCursor;
import ua.nure.social.net.tools.limit.CustomRateLimitStatus;
import ua.nure.social.net.tools.wrapper.PagableResponseWrapper;

import java.util.Map;

public class SafeTwitterUserClient extends TwitterUserClient {

    private static final Logger LOG = Logger.getLogger(SafeTwitterUserClient.class);

    private Map<String, RateLimitStatus> limits;

    @Override
    public SocialNode getUserById(Object screenName) {
        limitsReached("/friends/");
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

    //TODO
    private void limitsReached(String query) {
        try {
            if(getRateLimits(query, true).getRemaining() == 0) {
                Thread.sleep(getRateLimits(query, false).getSecondsUntilReset());
            }
        } catch(InterruptedException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private RateLimitStatus getRateLimits(String query, boolean cacheFirst) {
        try {
            if(limits == null || !cacheFirst) {
                limits = twitter.getRateLimitStatus();
            }
        } catch (TwitterException e) {
            LOG.error("Failed to get rate limits", e);
            return new CustomRateLimitStatus();
        }
        return limits.get(query);
    }
}
