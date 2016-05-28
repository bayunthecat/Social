package ua.nure.social.net.tools.wrapper;

import java.util.List;

public interface PagableResponseWrapper<T> {

    List<T> getResponseList();

    PageCursor getPageCursor();

}
