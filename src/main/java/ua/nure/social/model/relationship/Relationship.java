package ua.nure.social.model.relationship;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.StartNode;
import ua.nure.social.model.ModelEntity;
import ua.nure.social.model.node.SocialNode;

public abstract class Relationship extends ModelEntity {

    @StartNode
    private SocialNode from;

    @EndNode
    private SocialNode to;

    public Relationship(SocialNode from, SocialNode to) {
        if(!from.equals(to)) {
            this.from = from;
            this.to = to;
        }
    }

    public SocialNode getFrom() {
        return from;
    }

    public SocialNode getTo() {
        return to;
    }
}