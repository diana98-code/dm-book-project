package com.programacion.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.postgresql.ds.PGSimpleDataSource;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DatabaseConfigImpl implements DatabaseConfig {

    @Override
    public HikariConfig hikariConfig() {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setUser("postgres");
        ds.setPassword("postgres");
        ds.setPortNumbers(new int[5432]);
        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("library");
        ds.setLoadBalanceHosts(true);
        HikariConfig hc = new HikariConfig();
        hc.setDataSource(ds);
        hc.setMaximumPoolSize(6);
        return hc;
    }

    @Override
    public Jdbi getInstance() {
        return Jdbi.create(new HikariDataSource(hikariConfig()))
                .installPlugin(new PostgresPlugin())
                .installPlugin(new SqlObjectPlugin());
    }

}
