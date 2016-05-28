package ua.nure.social.net.tools.wrapper.twitter;

import ua.nure.social.net.tools.wrapper.PageCursor;

public class TwitterPageCursor implements PageCursor<Long> {

    private Long value;

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
}
