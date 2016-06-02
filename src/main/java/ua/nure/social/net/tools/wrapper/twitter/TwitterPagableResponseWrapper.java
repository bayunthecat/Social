package ua.nure.social.net.tools.wrapper.twitter;

import ua.nure.social.model.node.SocialNode;
import ua.nure.social.net.tools.wrapper.PagableResponseWrapper;
import ua.nure.social.net.tools.cursor.PageCursor;

import java.util.List;

public class TwitterPagableResponseWrapper implements PagableResponseWrapper<SocialNode> {

    private List<SocialNode> response;

    private PageCursor cursor;

    public TwitterPagableResponseWrapper(List<SocialNode> response, PageCursor cursor) {
        this.response = response;
        this.cursor = cursor;
    }

    @Override
    public List<SocialNode> getResponseList() {
        return response;
    }

    @Override
    public PageCursor getPageCursor() {
        return cursor;
    }
}
