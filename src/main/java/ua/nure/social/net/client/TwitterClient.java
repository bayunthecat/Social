package ua.nure.social.net.client;

import com.google.gson.Gson;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

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

    public Gson getUsersByIds() {
        return new Gson();
    }
}
