package ua.nure.social.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import twitter4j.RateLimitStatus;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import ua.nure.social.analytics.builder.api.SocialGraphBuilder;
import ua.nure.social.model.node.SimpleTwitterUser;
import ua.nure.social.util.ObjectLoader;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class App {

    public static void main(String[] args) throws NoSuchMethodException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        callBuilder(ctx);
    }

    private static void callBuilder(ApplicationContext ctx) {
        SocialGraphBuilder builder = (SocialGraphBuilder) ctx.getBean("depthSocialGraphBuilder");
        Map<String, Object> params = new HashMap<>();
        params.put("screenName", "vasya");
        SimpleTwitterUser node = (SimpleTwitterUser) builder.build(params);
        System.out.println("Done ==> " + node);
    }

    private static void saveSomeBullshit() {
        Twitter twitter = TwitterFactory.getSingleton();
        ObjectLoader loader = new ObjectLoader();
        try {
            Map<String, RateLimitStatus> status = twitter.getRateLimitStatus();
            loader.loadObjectToFile(status, "rateLimitsMap.obj");
        } catch (TwitterException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static Map<String, RateLimitStatus> getRateLimitsSample(String fileName) {
        ObjectLoader loader = new ObjectLoader();
        return (Map<String, RateLimitStatus>) loader.loadObjectFromFile(fileName);
    }

}