package com.bancolombia.cli;


import com.bancolombia.model.Product;

import java.util.Scanner;

public class CreateProduct {

    public void createProductInDB(){

        System.out.println("CREAR Producto EN LA BASE DE DATOS");
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

        //Guardando productos. El método estático crea el objeto  para el tiempo de ejecución así  como lo almacena de manera persistente.
        Product.createProduct(name, description, price, category, stock, true);


    }
}
