/*package com.bancolombia.model;


import com.bancolombia.dao.ProductDAO;
import com.bancolombia.dao.UserKidDAO;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Creando productos. El constructor crea el objeto para el tiempo de ejecución.

        Product productA = new Product("kit escolar",
                "para el aumento del conocimiento de nuestros niños",
                80000,
                "escolar",
                5);



        //Guardando productos. El método estático crea el objeto  para el tiempo de ejecución así  como lo almacena de manera persistente.
        Product.createProduct("pase planetario"," viaja por el espacio",25000,"recreacion",500, true);

        //Obteniendo cada producto por id.
        Product product1 = ProductDAO.getProductByID(1);
        Product product2 = ProductDAO.getProductByID(2);
        Product product3 = ProductDAO.getProductByID(62);



        //Creando un carrito y añadiendo productos
        Cart cart1 = new Cart();
        cart1.AddProduct(product1);
        cart1.AddProduct(product2);
        cart1.AddProduct(product3);


        //Obteniendo todos los productos del carrito
        cart1.getSelectedProducts();
        cart1.DeleteProduct(0); //Borrando el primer elemento de la lista de productos en el carrito
        cart1.getSelectedProducts();

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
*/