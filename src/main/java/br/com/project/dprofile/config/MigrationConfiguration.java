package br.com.project.dprofile.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MigrationConfiguration {

    @Autowired
    public MigrationConfiguration(DataSource dataSource, FlywayProperties flywayProperties) {
        try {
            Flyway.configure()
                    .schemas(flywayProperties.getSchemas())
                    .locations(flywayProperties.getLocations())
                    .baselineOnMigrate(true)
                    .baselineDescription(flywayProperties.getBaselineDescription())
                    .dataSource(dataSource)
                    .load()
                    .migrate();
        } catch (Throwable e) {
            if (!flywayProperties.isContinueOnFail()) {
                throw e;
            }
        }
    }
}
