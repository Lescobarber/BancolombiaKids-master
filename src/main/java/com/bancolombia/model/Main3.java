package com.bancolombia.model;


import com.bancolombia.dao.ProductDAO;
import com.bancolombia.dao.UserKidDAO;

import java.util.ArrayList;

public class Main3 {

    public static void main(String[] args) {





        //Guardando productos. El método estático crea el objeto  para el tiempo de ejecución así  como lo almacena de manera persistente.
        Product.createProduct("pase planetario"," viaja por el espacio",25000,"recreacion",500, true);

        //Obteniendo cada producto por id.
        Product product1 = ProductDAO.getProductByID(1);
        Product product2 = ProductDAO.getProductByID(2);
        Product product3 = ProductDAO.getProductByID(65);



        //Creando un carrito y añadiendo productos
        Cart cart1 = new Cart();
        cart1.AddProduct(product1);
        cart1.AddProduct(product2);
        cart1.AddProduct(product3);


        //Obteniendo todos los productos del carrito
        cart1.getSelectedProducts();


    }
}
