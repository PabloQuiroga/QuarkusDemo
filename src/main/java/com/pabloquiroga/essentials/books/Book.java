package com.pabloquiroga.essentials.books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id @GeneratedValue public Long id;
    public String author;
    public String anio_lanzamiento;
    public String editorial;
}
