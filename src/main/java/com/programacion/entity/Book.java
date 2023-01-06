package com.programacion.entity;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private String author;
    private double price;

}
