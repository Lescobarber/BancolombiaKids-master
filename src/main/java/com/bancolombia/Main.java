package com.bancolombia;

import com.bancolombia.cli.AddInCartBDProducts;
import com.bancolombia.cli.AddInCartRuntimeProduct;
import com.bancolombia.cli.CreateProduct;
import com.bancolombia.cli.HandleUserkid;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("MENÚ PRINCIPAL");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona una Opción");
        System.out.println("1-Añadir al Carrito un Producto de tiempo de ejecución");
        System.out.println("2-Guardar Producto en la base de datos");
        System.out.println("3-Añadir al Carrito varios Productos tomados de la base de datos dado su id");
        System.out.println("4-Crear un Usuario en la base de datos, loggearlo y actualizar su perfil");

        int option = scanner.nextInt();
        switch(option){
            case 1:
                AddInCartRuntimeProduct addInCartRuntimeProduct = new AddInCartRuntimeProduct();
                addInCartRuntimeProduct.AddRuntimeProduct();
                break;
            case 2:
                CreateProduct createProduct = new CreateProduct();
                createProduct.createProductInDB();
                break;
            case 3:
                AddInCartBDProducts addInCartBDProducts = new AddInCartBDProducts();
                addInCartBDProducts.addBDProducts();
                break;
            case 4:
                HandleUserkid handleUserkid = new HandleUserkid();
                handleUserkid.handleUserkid();
                break;
            default:
                System.out.println("No seleccionaste una opción válida");

        }
    }
}
