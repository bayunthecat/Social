package ua.nure.social.exec;

import ua.nure.social.net.client.TwitterClient;

public class App {

    public static void main(String[] args) {
        TwitterClient client = new TwitterClient();
        Object object = client.getUserById("sranysovok");
        System.out.println(object);
    }

}