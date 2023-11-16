package com.bancolombia.model;

import com.bancolombia.dao.UserKidDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class UserKid {
    private int userkidID;
    private String username;
    private String password;
    private String name;
    private int age;
    private String loginData;
    private List<String> hobbies;

    public UserKid(String username, String password, String name, int age) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        hobbies = new ArrayList<>();


    }

    public int getUserKidID() {
        return userkidID;
    }

    public void setUserKidID(int userkidID) {
        this.userkidID = userkidID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLoginData() {
        return loginData;
    }

    public void setLoginData(String loginData) {
        this.loginData = loginData;
    }

    public String getHobbies() {

        String delim = ", ";
        StringBuilder sb = new StringBuilder();
        String strHobbies;
        int i = 0;
        while (i < this.hobbies.size() - 1)
        {
            sb.append(this.hobbies.get(i));
            sb.append(delim);
            i++;
        }
        if (i>0) {
            sb.append(this.hobbies.get(i));
            strHobbies = sb.toString();
        }
        else{
            strHobbies = "";
        }
        return strHobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void UpdateProfile(UserKid userKid){
        //TODO: Preguntar al usuario qué desea agregar o cambiar en el perfil (atributos a agregar acá
        // y registros a agregar en BD)
        UserKidDAO.updateUserKid(userKid);
        System.out.println("Tus hobbies han sido agregados y son: " + userKid.getHobbies());
    }

    public static UserKid Login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce usuario");
        String username = scanner.nextLine();
        System.out.println("Introduce contraseña");
        String password = scanner.nextLine();

        UserKid userKid = UserKidDAO.authenticateUserKid(username, password);
        if(userKid == null){
            System.out.println("Usuario y/o contraseña incorrectos");
            Login();
        } else {
            System.out.println("Usuario Autenticado. Bienvenido " + userKid.name + "!");
        }
        return userKid;
    }

    public void SignOut(){
        //
    }
}
