package ua.nure.social.model.node;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.neo4j.annotation.QueryResult;
import ua.nure.social.util.Const;

@QueryResult
@NodeEntity(label = Const.Neo4j.Node.USER)
public class SimpleTwitterUser extends SocialNode {

    @Property(name = Const.Neo4j.Property.SCREEN_NAME)
    private String screenName;

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
