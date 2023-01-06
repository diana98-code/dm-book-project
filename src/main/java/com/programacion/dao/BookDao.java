package com.programacion.dao;

import com.programacion.entity.Book;
import com.programacion.entity.mapper.BookMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(BookMapper.class)
public interface BookDao {

    @SqlQuery("SELECT * FROM book")
    List<Book> findAll();

    @SqlQuery("SELECT * FROM book WHERE id = :id")
    Book findById(@Bind("id") Integer id);

    @SqlUpdate("INSERT INTO book (isbn, title, author, price) VALUES (:book.isbn, :book.title, :book.author, :book.price)")
    @GetGeneratedKeys
    Long insert(@BindBean("book") Book book);

    @SqlUpdate("UPDATE book SET isbn = :book.isbn, title = :book.title, author = :book.author, price = :book.price WHERE id = :id")
    @GetGeneratedKeys
    Long update(@BindBean("book") Book book, @Bind("id") Integer id);

    @SqlUpdate("DELETE FROM book WHERE id = :id")
    void delete(@Bind("id") Integer id);

}
