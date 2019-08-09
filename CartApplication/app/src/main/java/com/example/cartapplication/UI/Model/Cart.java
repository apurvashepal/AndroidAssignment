package com.example.cartapplication.UI.Model;

import com.example.cartapplication.UI.Database.Productentity;

public class Cart {
    Productentity product;
    int Quantity;

    public Productentity getProduct() {
        return product;
    }

    public void setProduct(Productentity product) {
        this.product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
