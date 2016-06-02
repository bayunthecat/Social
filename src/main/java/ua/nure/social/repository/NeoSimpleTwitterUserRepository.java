package ua.nure.social.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ua.nure.social.analytics.builder.tools.extractor.field.FieldExtractor;
import ua.nure.social.model.node.SimpleTwitterUser;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class NeoSimpleTwitterUserRepository {

    @Autowired
    private SocialNodeRepository repository;

    private FieldExtractor screenNameExtractor;

    public SimpleTwitterUser saveNode(SimpleTwitterUser node) {
        List<SimpleTwitterUser> existingUsers = repository.getUsersByScreenNames(getRelationshipSocialIds(node));
        mapExistedUsers(node, existingUsers);
        repository.save(node);
        return node;
    }

    private String[] getRelationshipSocialIds(SimpleTwitterUser node) {
        List<String> socialIds = new ArrayList<>();
        socialIds.add(node.getScreenName());
        node.getFollowers().stream().forEach(relationship -> socialIds.add((String) screenNameExtractor.extract(relationship)));
        node.getFriends().stream().forEach(relationship -> socialIds.add((String) screenNameExtractor.extract(relationship)));
        return socialIds.toArray(new String[] {});
    }

    private SimpleTwitterUser mapExistedUsers(SimpleTwitterUser node, List<SimpleTwitterUser> existingUsers) {
        node.getFollowers().forEach(follower -> follower.setId(getId(existingUsers, (String) screenNameExtractor.extract(follower))));
        node.getFriends().forEach(friend -> friend.setId(getId(existingUsers, (String) screenNameExtractor.extract(friend))));
        return node;
    }

    private Long getId(List<SimpleTwitterUser> existingUsers, String screenName) {
        return existingUsers.stream().filter(user -> user.getScreenName().equals(screenName)).findFirst().orElse(new SimpleTwitterUser()).getId();
    }

    public void setScreenNameExtractor(FieldExtractor screenNameExtractor) {
        this.screenNameExtractor = screenNameExtractor;
    }

}
