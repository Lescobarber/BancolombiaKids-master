package com.bancolombia.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int cartID;
    private int userkidID;
    private List<Product> selectedProducts;
    //TODO: Agregar atributo paid y guardar los productos del carrito en la BD (tabla shoppingregistry) cuando haya sido pagado


    public Cart(){
        selectedProducts = new ArrayList<>();
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getUserkidID() {
        return userkidID;
    }

    public void setUserkidID(int userkidID) {
        this.userkidID = userkidID;
    }

    public void getSelectedProducts() {

        // Especificar ruta de archivo
        String filePath = "output.txt";

        int i = 1;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header
            writer.write("#, Name, Price, Taxes");
            writer.newLine();

            System.out.println("Actualmente los productos del carrito son:");
            for (Product element:this.selectedProducts) {
                System.out.printf("%3d|%20s|$%20s|$%20s|%n", i, element.getName(), element.getPrice(), element.CalcTaxes(19));
                writer.write(String.format("%3d|%20s|$%20s|$%20s|%n", i, element.getName(), element.getPrice(), element.CalcTaxes(19)));
                writer.newLine();
                i++;
            }
            writer.write("TOTAL");
            writer.write(String.valueOf(this.CalcTotal()));
            System.out.printf("TOTAL $%61s|%n", this.CalcTotal());
            System.out.println("Se ha generado una factura en este directorio!");
        } catch (IOException e){
            e.printStackTrace();
        }

        //return selectedProducts; //Debería retornarse una lista de los productos seleccionados para hacer
        //la presentación con otra(s) clase(s)
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public void AddProduct(Product product){
        this.selectedProducts.add(product);
        System.out.println("Producto " + product.getName() + " agregado Exitosamente al carrito");
    }

    public void DeleteProduct(int i){
        String name = this.selectedProducts.get(i).getName();
        this.selectedProducts.remove(i);
        System.out.println("Producto " + name + " eliminado Exitosamente del carrito");
    }

    public double CalcTotal(){
        double total = 0;
        for (Product element:this.selectedProducts) {
            total += element.getPrice() + element.CalcTaxes(19);
        }
        return total;
    }

    public void ProcessShopping(){
        //

    }
}
