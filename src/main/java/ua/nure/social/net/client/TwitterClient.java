package ua.nure.social.net.client;

import com.google.gson.Gson;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class TwitterClient {

    private Twitter twitter = TwitterFactory.getSingleton();

    public Gson getUserById() {
        return new Gson();
    }

    public Gson getUsersByIds() {
        return new Gson();
    }
}
