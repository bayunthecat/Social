package ua.nure.social.net.tools.cursor;

public interface PageCursor<T> {

    T getCursor();

    void setCursor(T value);

    void reset();

    boolean isFinished();
}
