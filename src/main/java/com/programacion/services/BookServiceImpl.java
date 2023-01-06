package com.programacion.services;

import com.programacion.config.DatabaseConfig;
import com.programacion.dao.BookDao;
import com.programacion.entity.Book;
import com.sun.source.tree.ConditionalExpressionTree;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.postgresql.ds.PGSimpleDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    @Inject
    private DatabaseConfig databaseConfig;

    @Override
    public List<Book> findAll() {
        Jdbi jdbi = databaseConfig.getInstance();
        return jdbi.withExtension(BookDao.class, dao -> dao.findAll());
    }

    @Override
    public Book findById(Integer id) {
        Jdbi jdbi = databaseConfig.getInstance();
        return jdbi.withExtension(BookDao.class, dao -> dao.findById(id));
    }

    @Override
    public void insert(Book book) {
        Jdbi jdbi = databaseConfig.getInstance();
        jdbi.withExtension(BookDao.class, dao -> dao.insert(book));
    }

    @Override
    public void update(Book book, Integer id) {
        Jdbi jdbi = databaseConfig.getInstance();
        jdbi.withExtension(BookDao.class, dao -> dao.update(book, id));
    }

    @Override
    public void delete(Integer id) {
        Jdbi jdbi = databaseConfig.getInstance();
        jdbi.withHandle(handle -> handle.execute("DELETE FROM book WHERE id = ?", id));
    }

}
