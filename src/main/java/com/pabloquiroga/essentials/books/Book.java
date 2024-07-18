package com.pabloquiroga.essentials.books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Book {
    @Id @GeneratedValue public Long id;
    public String author;
    public String anio_lanzamiento;
    public String editorial;

    public Book(){}
    public Book(String author, String anio_lanzamiento, String editorial) {
        this.author = author;
        this.anio_lanzamiento = anio_lanzamiento;
        this.editorial = editorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnio_lanzamiento() {
        return anio_lanzamiento;
    }

    public void setAnio_lanzamiento(String anio_lanzamiento) {
        this.anio_lanzamiento = anio_lanzamiento;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(author, book.author) && Objects.equals(anio_lanzamiento, book.anio_lanzamiento) && Objects.equals(editorial, book.editorial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, anio_lanzamiento, editorial);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", anio_lanzamiento='" + anio_lanzamiento + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }
}
