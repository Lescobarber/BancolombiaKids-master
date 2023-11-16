package com.bancolombia.model;

import com.bancolombia.dao.ProductDAO;

import java.sql.*;

public class Product {
    private int productID;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stock;
    //TODO: Agregar fees a cada producto según su categoría



    public static Product createProduct(String name, String description, double price, String category, int stock, boolean insertIntoDatabase) {
        Product product = new Product(name, description, price, category, stock);
        if (insertIntoDatabase) {
            // Call insertProduct or perform other operations
            ProductDAO.insertProduct(product.name, product.description, product.price, product.category, product.stock);
        }
        return product;
    }

    public Product(String name, String description, double price, String category, int stock) {
        // Constructor logic
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void GetInfo(int productID) {
    }

    // ...

    public void UpdateStock(int stock){
        //
    }

    public double CalcTaxes(int fees){
        //
        return this.getPrice()*((double) fees /100);
    }
}


