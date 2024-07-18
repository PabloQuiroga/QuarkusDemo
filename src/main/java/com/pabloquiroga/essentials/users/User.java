package com.pabloquiroga.essentials.users;

import com.pabloquiroga.essentials.utils.Dates;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

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
        //this.id = setRandomId();
        this.name = name;
        this.surname = surname;
    }
    public User(String name, String surname, String birthdate){
        this(name, surname);
        this.birthdate = Dates.parseDate(birthdate);
        this.age = setAgeFromBirthdate();
    }
    public static User of(String name, String surname, String birthdate){
        return new User(name, surname, birthdate);
    }

    /**
     * GETTERS Y SETTERS
     */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * EQUALS, HASHCODE y ToString
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(birthdate, user.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, birthdate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", birthdate=" + birthdate +
                '}';
    }

    /**
     * Utils
     */
    private int setAgeFromBirthdate(){
        return Period.between(this.birthdate, LocalDate.now()).getYears();
    }

    private int setRandomId(){
        Random aleatorio = new Random(System.currentTimeMillis());
        return aleatorio.nextInt();
    }
}
