package ua.nure.social.net.tools.wrapper;

public interface PageCursor<T> {
    T getCursor();

    void setCursor(T value);
}
