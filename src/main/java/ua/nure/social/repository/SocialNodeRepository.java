package ua.nure.social.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import ua.nure.social.model.node.SimpleTwitterUser;
import ua.nure.social.model.node.SocialNode;

import java.util.List;

public interface SocialNodeRepository extends GraphRepository<SimpleTwitterUser> {

    String USER_MAPPER_ENDING = "user.screenName AS screenName, " +
            "COLLECT(follower) AS followers, " +
            "COLLECT(friend) AS friends, " +
            "id(user) AS id";

    @Query( "MATCH (user:User) " +
            "WHERE user.screenName = {0} " +
            "OPTIONAL MATCH (user)<-[:FOLLOWS]-(follower:User), (user)-[:FRIEND_WITH]->(friend:User) " +
            "RETURN"
            + USER_MAPPER_ENDING)
    SimpleTwitterUser getUserByScreenName(String screenName);

    @Query( "MATCH (user:User) WHERE user.screenName IN {0} RETURN user.screenName AS screenName, id(user) AS id")
    List<SimpleTwitterUser> getUsersByScreenNames(String... screenNames);
}