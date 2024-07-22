package com.pabloquiroga.essentials.users;

import com.pabloquiroga.essentials.utils.Dates;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id @GeneratedValue
    public int id;
    public String name;
    public String surname;
    public int age;
    public LocalDate birthdate;

    public User(){}
    public User(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    public User(String name, String surname, String birthdate){
        this(name, surname);
        this.birthdate = Dates.parseDate(birthdate);
    }
    public static User of(String name, String surname, String birthdate){
        return new User(name, surname, birthdate);
    }

    /**
     * Utils
     */
    public static int setAgeFromBirthdate(LocalDate birthdate){
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
