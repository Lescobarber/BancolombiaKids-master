package com.bancolombia.cli;


import com.bancolombia.dao.ProductDAO;
import com.bancolombia.model.Cart;
import com.bancolombia.model.Product;

import java.util.Scanner;

public class AddInCartBDProducts {

    public void addBDProducts(){

        System.out.println("AÑADIR AL Carrito TRES Productos DESDE LA BASE DE DATOS");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce Id del primer Producto");
        int id1 = scanner.nextInt();

        System.out.println("Introduce Id del segundo Producto");
        int id2 = scanner.nextInt();

        System.out.println("Introduce Id del tercer Producto");
        int id3 = scanner.nextInt();


        //Obteniendo cada producto por id.
        Product product1 = ProductDAO.getProductByID(id1);
        Product product2 = ProductDAO.getProductByID(id2);
        Product product3 = ProductDAO.getProductByID(id3);


        //Creando un carrito y añadiendo productos
        Cart cart1 = new Cart();
        cart1.AddProduct(product1);
        cart1.AddProduct(product2);
        cart1.AddProduct(product3);


        //Obteniendo todos los productos del carrito
        cart1.getSelectedProducts();

        //Borrando el primer elemento de la lista de productos en el carrito
        cart1.DeleteProduct(0);
        cart1.getSelectedProducts();

    }
}
