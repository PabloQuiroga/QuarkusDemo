package com.pabloquiroga.essentials.users;

import com.pabloquiroga.essentials.utils.Dates;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class User {
    public int id;
    public String name;
    public String surname;
    public int age;
    public LocalDate birthdate;

    public User(){}
    public User(String name, String surname){
        this.id = setRandomId();
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
     * GETTERS
     */
    public int getID() {
        return this.id;
    }

    private int setAgeFromBirthdate(){
        return Period.between(this.birthdate, LocalDate.now()).getYears();
    }

    /**
     * @return random Id
     */
    private int setRandomId(){
        Random aleatorio = new Random(System.currentTimeMillis());
        return aleatorio.nextInt();
    }
}
