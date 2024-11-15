package org.makila.api.config;


import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "org.makila.api.repository.postgresql"
)
public class PostgreSQLConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.postgresql")
    public DataSourceProperties postgresDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource postgresDataSource() {
        return postgresDataSourceProperties()
            .initializeDataSourceBuilder()
            .type(org.postgresql.ds.PGSimpleDataSource.class)
            .build();
    }
}
