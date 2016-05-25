package ua.nure.social.analytics.mapper;

import ua.nure.social.model.node.SocialNode;

public interface RelationshipCreater {

    void createRelationship(SocialNode from, SocialNode to);

}