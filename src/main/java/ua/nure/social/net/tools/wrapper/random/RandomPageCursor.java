package ua.nure.social.net.tools.wrapper.random;

import ua.nure.social.net.tools.wrapper.PageCursor;

public class RandomPageCursor implements PageCursor<Long> {

    @Override
    public Long getCursor() {
        return 0L;
    }

    @Override
    public void setCursor(Long value) {}
}
