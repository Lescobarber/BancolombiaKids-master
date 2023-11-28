package com.bancolombia.model;


import com.bancolombia.dao.ProductDAO;
import com.bancolombia.dao.UserKidDAO;

import java.util.ArrayList;

public class Main5 {

    public static void main(String[] args) {


        //Creando un usuario
        UserKid userkid1 = new UserKid("braes","123456","Brayan Esneider",18);
        UserKidDAO.insertUserKid(userkid1);

        //Login de usuario. Cualquier persona
        userkid1 = UserKid.Login();

        //Añadiendo hobbies al perfil del usuario
        ArrayList<String> list = new ArrayList<>();
        list.add("Futbol");
        list.add("echando verbo a las niñas");
        userkid1.setHobbies(list);
        //TODO: set avatar
        // set address etc...
        //Actualizando el perfil
        userkid1.UpdateProfile(userkid1);
    }
}
