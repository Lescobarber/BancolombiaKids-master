package com.bancolombia.model;

import java.util.List;

public class ShoppingRegistry {
    private int registerID;
    private int userkidID;
    private int productID;
    private String shopppingDate;


    //TODO: Debe crearse un registro cuando un prodcuto haya sido comprado. ¿es posible verificar que un carrito haya sido sido pagado?
    //TODO:un producto ha sido comprado, si el usuario lo ha puesto en el carrito de compras y ha pagado por el; es decir ha finalizado el proceso de
    // compra satisfactoriamente
    public int getRegisterID() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public int getUserkidID() {
        return userkidID;
    }

    public void setUserkidID(int userkidID) {
        this.userkidID = userkidID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getShopppingDate() {
        return shopppingDate;
    }

    public void setShopppingDate(String shopppingDate) {
        this.shopppingDate = shopppingDate;
    }


}
