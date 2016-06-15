package ua.nure.social.net.client;

import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.TwitterException;
import ua.nure.social.net.mapper.TwitterSimpleUserMapper;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.tools.converter.ResponseConverter;
import ua.nure.social.net.tools.wrapper.PagableResponseWrapper;
import ua.nure.social.net.tools.cursor.PageCursor;
import ua.nure.social.net.tools.wrapper.twitter.TwitterPagableResponseWrapper;
import ua.nure.social.net.tools.cursor.twitter.TwitterPageCursor;
import ua.nure.social.util.Const;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TwitterUserClient implements SocialUserClient<SocialNode, Long> {

    private static Logger LOG = Logger.getLogger(TwitterUserClient.class);

    @Autowired
    @Resource(name = Const.Spring.Components.TWITTER_PAGABLE_TRANSFORMER)
    private ResponseConverter<PagableResponseList<User>, List<User>> responseConverter;

    protected Twitter twitter = TwitterFactory.getSingleton();

    @Override
    public SocialNode getUserById(Object screenName) {
        SocialNode user = null;
        try {
            user = new TwitterSimpleUserMapper().map(twitter.showUser((String) screenName));
        } catch (TwitterException e) {
            LOG.error("Failed to fetch user ==> " + screenName, e);
        }
        return user;
    }

    @Override
    public PagableResponseWrapper<SocialNode> getFollowers(Object screenName, PageCursor<Long> cursor, int count) {
        try {
            PagableResponseList<User> response = twitter.getFollowersList((String) screenName, cursor.getCursor(), count);
            List<User> users = responseConverter.convert(response);
            return new TwitterPagableResponseWrapper(mapList(users), new TwitterPageCursor(response.getNextCursor()));
        } catch (TwitterException e) {
            LOG.error("Failed to fetch followers for user ==> " + screenName, e);
        }
        return null;
    }

    @Override
    public PagableResponseWrapper<SocialNode> getFriends(Object screenName, PageCursor<Long> cursor, int count) {
        try {
            PagableResponseList<User> response = twitter.getFriendsList((String) screenName, cursor.getCursor(), count);
            List<User> users = responseConverter.convert(response);
            return new TwitterPagableResponseWrapper(mapList(users), new TwitterPageCursor(response.getNextCursor()));
        } catch (TwitterException e) {
            LOG.error("Failed to fetch friends for user ==> " + screenName, e);
        }
        return null;
    }

    private List<SocialNode> mapList(List<User> users) {
        List<SocialNode> list = new ArrayList<>();
        TwitterSimpleUserMapper mapper = new TwitterSimpleUserMapper();
        list.addAll(users.stream().map(mapper::map).collect(Collectors.toList()));
        return list;
    }
}
