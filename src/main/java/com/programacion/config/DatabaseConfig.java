package com.programacion.config;

import com.zaxxer.hikari.HikariConfig;
import org.jdbi.v3.core.Jdbi;

public interface DatabaseConfig {

    HikariConfig hikariConfig();

    Jdbi getInstance();

}
