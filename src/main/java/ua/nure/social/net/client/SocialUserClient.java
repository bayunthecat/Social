package ua.nure.social.net.client;

import java.util.List;

public interface SocialUserClient<T> {

    T getUserById(String id);

    List<T> getFollowers(Object id, int count);

    List<T> getFriends(Object id, int count);

}