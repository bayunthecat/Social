package ua.nure.social.model.node;

import org.neo4j.ogm.annotation.Relationship;
import ua.nure.social.model.ModelEntity;
import ua.nure.social.util.Const;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class SocialNode extends ModelEntity {

    @Relationship(type = Const.Neo4j.Relationship.FOLLOWER, direction = Relationship.INCOMING)
    private List<SocialNode> followers;

    @Relationship(type = Const.Neo4j.Relationship.FRIEND, direction = Relationship.UNDIRECTED)
    private List<SocialNode> friends;

    public SocialNode() {
        followers = new ArrayList<>();
        friends = new ArrayList<>();
    }

    public SocialNode addFollower(SocialNode follower) {
        followers.add(follower);
        return follower;
    }

    public SocialNode addFriend(SocialNode friend) {
        friends.add(friend);
        return friend;
    }

    public List<SocialNode> addFollowers(Collection<SocialNode> followers) {
        this.followers.addAll(followers);
        return new ArrayList<>(followers);
    }

    public List<SocialNode> addFriends(Collection<SocialNode> friends) {
        this.friends.addAll(friends);
        return new ArrayList<>(friends);
    }

    public List<SocialNode> getFollowers() {
        return followers;
    }

    public List<SocialNode> getFriends() {
        return friends;
    }
}
