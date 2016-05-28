package ua.nure.social.exec;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.nure.social.analytics.mapper.TwitterSimpleUserMapper;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.client.TwitterUserClient;
import ua.nure.social.repository.TwitterUserRepository;
import ua.nure.social.util.ObjectLoader;

public class App {

    public static void main(String[] args) throws NoSuchMethodException {
        Logger LOG =Logger.getLogger(App.class);
        String serializedUser = "serializedTwitterUser.obj";
        String serializedFollowers = "serializedFollowers.obj";
        ObjectLoader loader = new ObjectLoader();
        Object pacan = loader.loadObjectFromFile(serializedUser);

        SocialNode node = new TwitterSimpleUserMapper().map(pacan);
//        System.out.println("Done ==> " + pacan);
//        System.out.println("Mapped ==> " + node);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        TwitterUserRepository repo = ctx.getBean(TwitterUserRepository.class);

//        TwitterUserClient client = new TwitterClient();
//        client.getUserById("sranysovok");

        System.out.println("Done");
    }

}