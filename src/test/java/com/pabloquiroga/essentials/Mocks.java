package com.pabloquiroga.essentials;

import com.pabloquiroga.essentials.users.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Simulacion de almacenamiento
 */
@ApplicationScoped
public class Mocks {

    public User u1 = new User("Juan","Perez","01/01/2000");
    public User randonUser = new User("pablo","Q","01/01/1978");;
    private List<User> usersList = new ArrayList<>();

    public boolean addNewUser(User u){
        return usersList.add(u);
    }

    public List<User> getUsersList(){
        return usersList;
    }

    private List<User> generateListOfUser() {
        List<User> listado = new ArrayList<>();

        for (int i=0; i<5; i++){
            String nombre = "nombre" + i;
            String apellido = "apellido" + i;
            String nacimiento = getRandomDate();
            User u = new User(nombre, apellido, nacimiento);
            listado.add(u);
            if (i==5){
                randonUser = u;
            }
        }

        return listado;
    }

    private String getRandomDate(){
        Long max =0L;
        Long min =100000000000L;
        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");

        Random r = new Random();
        Long randomLong=(r.nextLong() % (max - min)) + min;
        Date dt =new Date(randomLong);

        return spf.format(dt);
    }
}
