package com.bancolombia.cli;


import com.bancolombia.model.Cart;
import com.bancolombia.model.Product;

import java.util.Scanner;

public class AddInCartRuntimeProduct {

    public void AddRuntimeProduct(){

        System.out.println("AÑADIR AL Carrito UN Producto DE TIEMPO DE EJECUCIÓN");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce nombre de Producto");
        String name = scanner.nextLine();

        System.out.println("Introduce descripción de Producto");
        String description = scanner.nextLine();

        System.out.println("Introduce precio de Producto");
        double price = scanner.nextDouble();

        System.out.println("Introduce categoría de Producto");
        String category = scanner.nextLine();

        System.out.println("Introduce stock de Producto");
        int stock = scanner.nextInt();

        //Creando producto para tiempo de ejecución
        Product productA = new Product(name,
                description,
                price,
                category,
                stock);

        //Creando un carrito y añadiendo productos
        Cart cart1 = new Cart();
        cart1.AddProduct(productA);

        //Obteniendo todos los productos del carrito
        cart1.getSelectedProducts();
    }
}
