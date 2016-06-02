package ua.nure.social.net.tools.wrapper;

import ua.nure.social.net.tools.cursor.PageCursor;

import java.util.List;

public interface PagableResponseWrapper<T> {

    List<T> getResponseList();

    PageCursor getPageCursor();

}
