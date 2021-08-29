package com.ecommerce.microcommerce.model;

public class CartLineInfo {

    private ProductInfo productInfo;
    private int quantity;
    private double TVA;

    public CartLineInfo() {
        this.quantity = 0;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return this.productInfo.getPrice() * this.quantity;
    }

    public void setTVA(double TVA) {
        this.TVA = TVA;
    }

    public double getTVA(){return TVA * this.quantity;}

}
