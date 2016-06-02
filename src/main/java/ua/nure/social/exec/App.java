package ua.nure.social.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.nure.social.analytics.builder.api.SocialGraphBuilder;
import ua.nure.social.model.node.SimpleTwitterUser;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) throws NoSuchMethodException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        SocialGraphBuilder builder = (SocialGraphBuilder) ctx.getBean("depthSocialGraphBuilder");

        Map<String, Object> params = new HashMap<>();
        params.put("screenName", "vasya");

        SimpleTwitterUser node = (SimpleTwitterUser) builder.build(params);

        System.out.println("Done ==> " + node);
    }

}