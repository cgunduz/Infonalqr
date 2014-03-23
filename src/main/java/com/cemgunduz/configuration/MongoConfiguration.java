package com.cemgunduz.configuration;

import com.cemgunduz.infonalqr.persistence.dao.UserMongoDao;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * Created by cgunduz on 3/13/14.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.cemgunduz.infonalqr.persistence.*",
        includeFilters = @ComponentScan.Filter(value = {UserMongoDao.class},
                type = FilterType.ASSIGNABLE_TYPE))
public class MongoConfiguration {

    public @Bean
    MongoTemplate mongoTemplate(Mongo mongo) throws UnknownHostException {
        return new MongoTemplate(mongo, "infonalqr");
    }

    public @Bean Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }
}
