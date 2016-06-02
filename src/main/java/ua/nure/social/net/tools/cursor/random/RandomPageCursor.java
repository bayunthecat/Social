package ua.nure.social.net.tools.cursor.random;

import ua.nure.social.net.tools.cursor.PageCursor;

public class RandomPageCursor implements PageCursor<Long> {

    private boolean finished;

    public RandomPageCursor() {
        finished = false;
    }

    public RandomPageCursor(boolean finished) {
        this.finished = finished;
    }

    @Override
    public Long getCursor() {
        return 0L;
    }

    @Override
    public void setCursor(Long value) {}

    @Override
    public void reset() {}

    @Override
    public boolean isFinished() {
        return finished;
    }
}
