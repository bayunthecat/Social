package ua.nure.social.net.tools.cursor.twitter;

import ua.nure.social.net.tools.cursor.PageCursor;

public class TwitterPageCursor implements PageCursor<Long> {

    private static final int CURSOR_FINISHED = 0;

    private static final long INITIAL_CURSOR_VALUE = -1L;

    private Long value;

    public TwitterPageCursor() {
        value = INITIAL_CURSOR_VALUE;
    }

    public TwitterPageCursor(long value) {
        this.value = value;
    }

    @Override
    public Long getCursor() {
        return value;
    }

    @Override
    public void setCursor(Long value) {
        this.value = value;
    }

    @Override
    public void reset() {
        value = INITIAL_CURSOR_VALUE;
    }

    @Override
    public boolean isFinished() {
        return value == CURSOR_FINISHED;
    }
}
