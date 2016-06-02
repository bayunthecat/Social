package ua.nure.social.net.tools.cursor.random;

import ua.nure.social.net.tools.cursor.PageCursor;
import ua.nure.social.net.tools.cursor.PageCursorFactory;

public class RandomPageCursorFactory implements PageCursorFactory{
    @Override
    public PageCursor getPageCursor() {
        return new RandomPageCursor();
    }
}
