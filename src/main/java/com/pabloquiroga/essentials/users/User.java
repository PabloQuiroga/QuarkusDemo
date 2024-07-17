package com.pabloquiroga.essentials.users;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class User {
    public int id;
    public String name;
    public String surname;
    public int age;
    public String birthdate;

    public User(){}
    public User(String name, String surname){
        this.id = setRandomId();
        this.name = name;
        this.surname = surname;
    }
    public User(String name, String surname, String birthdate){
        this(name, surname);
        this.birthdate = birthdate;
        this.age = setAgeFromBirthdate(birthdate);
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

    /**
     * @param birthdate with format "15/08/1993"
     */
    public int setAgeFromBirthdate(String birthdate){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(birthdate, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return periodo.getYears();
    }

    /**
     * @return random Id
     */
    private int setRandomId(){
        Random aleatorio = new Random(System.currentTimeMillis());
        return aleatorio.nextInt();
    }
}
