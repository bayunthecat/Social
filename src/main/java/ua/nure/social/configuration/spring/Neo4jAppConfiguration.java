package ua.nure.social.configuration.spring;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.nure.social.model.ModelEntity;
import ua.nure.social.util.Const;

@Configuration
@EnableNeo4jRepositories(Const.Neo4j.Configuration.REPO_PACKAGE)
@EnableTransactionManagement
public class Neo4jAppConfiguration extends Neo4jConfiguration {

    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            sessionFactory = new SessionFactory(ModelEntity.class.getPackage().getName());
        }
        return sessionFactory;
    }
}