package ua.nure.social.model.node;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import ua.nure.social.util.Const;

@NodeEntity(label = Const.Neo4j.Node.USER)
public class SimpleTwitterUser extends SocialNode {

    @Property(name = Const.Neo4j.Property.SCREEN_NAME)
    private String screenName;

    @Property(name = Const.Neo4j.Property.COUNTRY)
    private String country;

    public String getScreenName() {
        return screenName;
    }

    public String getCountry() {
        return country;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
