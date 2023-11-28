package com.bancolombia.model;


import com.bancolombia.dao.ProductDAO;
import com.bancolombia.dao.UserKidDAO;

import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) {

        //Creando productos. El constructor crea el objeto para el tiempo de ejecución.
        Product productA = new Product("kit escolar",
                "para el aumento del conocimiento de nuestros niños",
                80000,
                "escolar",
                5);




        //Creando un carrito y añadiendo productos
        Cart cart1 = new Cart();
        cart1.AddProduct(productA);



        //Obteniendo todos los productos del carrito
        cart1.getSelectedProducts();



    }
}
