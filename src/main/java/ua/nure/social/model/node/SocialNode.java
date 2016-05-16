package ua.nure.social.model.node;

import ua.nure.social.model.relationship.Relationship;

import java.util.Collections;
import java.util.Set;

public class SocialNode extends Node {

    private Set<Relationship> relationships;

    public Relationship addRelationship(Relationship relationship) {
        relationships.add(relationship);
        return relationship;
    }

    public Relationship removeRelationship(Relationship relationship) {
        return relationships.remove(relationship) ? relationship : null;
    }

    public Set getRelationship() {
        return Collections.unmodifiableSet(relationships);
    }

}
