package com.bancolombia.model;


import com.bancolombia.dao.ProductDAO;

public class Main4 {

    public static void main(String[] args) {







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

        cart1.DeleteProduct(0); //Borrando el primer elemento de la lista de productos en el carrito
        cart1.getSelectedProducts();




    }
}
