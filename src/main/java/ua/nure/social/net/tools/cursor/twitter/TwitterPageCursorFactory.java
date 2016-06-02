package ua.nure.social.net.tools.cursor.twitter;

import ua.nure.social.net.tools.cursor.PageCursor;
import ua.nure.social.net.tools.cursor.PageCursorFactory;

public class TwitterPageCursorFactory implements PageCursorFactory {

    private Class<?> clazz;

    @Override
    public PageCursor getPageCursor() {
        return new TwitterPageCursor();
    }
}
