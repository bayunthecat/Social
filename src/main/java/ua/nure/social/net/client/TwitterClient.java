package ua.nure.social.net.client;

import twitter4j.*;

public class TwitterClient {

    private Twitter twitter = TwitterFactory.getSingleton();

    public Object getUserById(String id) {
        User user = null;
        try {
            user = twitter.showUser(id);
        } catch (TwitterException e) {
            System.out.println("Oops!");
        }
        return user;
    }

    public Object getUsersByIds() {
        return null;
    }

    public Object getFollowers(String id) {
        try {
            PagableResponseList<User> response = twitter.getFollowersList(id, -1);
            response.getNextCursor();
            return response;
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
