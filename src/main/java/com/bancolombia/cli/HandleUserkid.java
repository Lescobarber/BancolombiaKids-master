package com.bancolombia.cli;


import com.bancolombia.dao.ProductDAO;
import com.bancolombia.dao.UserKidDAO;
import com.bancolombia.model.Cart;
import com.bancolombia.model.Product;
import com.bancolombia.model.UserKid;

import java.util.ArrayList;
import java.util.Scanner;

public class HandleUserkid {

    public void handleUserkid(){

        System.out.println("CREAR Y GESTIONAR UN Userkid TANTO EN BD COMO EN TIEMPO DE EJECUIÓN");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce nombre de Userkid");
        String name = scanner.nextLine();

        System.out.println("Introduce edad del Userkid");
        int age = scanner.nextInt();

        System.out.println("Introduce username de Userkid");
        String username = scanner.nextLine();

        System.out.println("Introduce password de Userkid");
        String password = scanner.nextLine();

        //Creando un usuario
        UserKid userkid1 = new UserKid(username,password,name,age);
        UserKidDAO.insertUserKid(userkid1);

        //Login de usuario. Cualquier persona
        userkid1 = UserKid.Login();

        //Añadiendo hobbies al perfil del usuario
        System.out.println("Ahora agrega los hobbies de " + name);
        ArrayList<String> list = new ArrayList<>();
        int i = 1;
        while(true){
            System.out.println("Introduce hobbie " + i);
            String hobbie = scanner.nextLine();
            list.add(hobbie);
            System.out.println("Deseas agregar más hobbies? S/N");
            char myContinue = scanner.next().charAt(0);
            if(myContinue == 'N'){
                break;
            }
            i++;
        }
        userkid1.setHobbies(list);

        //TODO: set avatar
        // set address etc...
        //Actualizando el perfil
        userkid1.UpdateProfile(userkid1);
    }
}
