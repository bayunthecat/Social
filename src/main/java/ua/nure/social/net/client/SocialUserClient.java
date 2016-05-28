package ua.nure.social.net.client;

import ua.nure.social.net.tools.wrapper.PagableResponseWrapper;
import ua.nure.social.net.tools.wrapper.PageCursor;

public interface SocialUserClient<T, C> {

    T getUserById(String id);

    PagableResponseWrapper<T> getFollowers(Object id, PageCursor<C> cursor, int count);

    PagableResponseWrapper<T> getFriends(Object id, PageCursor<C> cursor ,int count);

}