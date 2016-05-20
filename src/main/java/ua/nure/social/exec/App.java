package ua.nure.social.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.nure.social.analytics.mapper.TwitterUserMapper;
import ua.nure.social.configuration.TwitterUserMapperConfiguration;
import ua.nure.social.model.node.SocialNode;
import ua.nure.social.util.ObjectLoader;

public class App {

    public static void main(String[] args) {
        String fileName = "serializedTwitterUser.obj";
        ObjectLoader loader = new ObjectLoader();
        Object pacan = loader.loadObjectFromFile(fileName);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

        SocialNode node = new TwitterUserMapper((TwitterUserMapperConfiguration) ctx.getBean("twitterUserMapperConfiguration")).map(pacan);
        System.out.println("Done ==> " + pacan);
        System.out.println("Mapped ==> " + node);
    }

}