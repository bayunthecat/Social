package ua.nure.social.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import ua.nure.social.model.node.SimpleTwitterUser;

public interface TwitterUserRepository extends GraphRepository<SimpleTwitterUser> {
}