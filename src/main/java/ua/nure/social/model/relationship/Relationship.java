package ua.nure.social.model.relationship;

import ua.nure.social.model.BaseItem;

public class Relationship extends BaseItem {

    private String from;

    private String to;

    public Relationship(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}