package com.pabloquiroga.essentials.books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Book {
    @Id @GeneratedValue public Long id;
    public String title;
    public String author;
    public String anio_lanzamiento;
    public String editorial;

    public Book() {}

    public Book(String title, String author, String anio_lanzamiento, String editorial) {
        this.title = title;
        this.author = author;
        this.anio_lanzamiento = anio_lanzamiento;
        this.editorial = editorial;
    }

    public Book(Long id, String title, String author, String anio_lanzamiento, String editorial) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.anio_lanzamiento = anio_lanzamiento;
        this.editorial = editorial;
    }
}
