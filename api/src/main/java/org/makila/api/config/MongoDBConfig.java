package org.makila.api.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
    basePackages = "org.makila.api.repository.mongodb"
)
public class MongoDBConfig {
}
