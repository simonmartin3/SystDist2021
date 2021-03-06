package com.ecommerce.microcommerce.model;

import com.ecommerce.microcommerce.dao.ProductDAO;
import com.ecommerce.microcommerce.entity.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartInfo {

    private int orderNum;
    private Date orderDate;
    private int shipping = 5;

    private CustomerInfo customerInfo;

    private ProductDAO productDAO;

    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

    public CartInfo() {

    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderDate() {return orderDate;}

    public void setOrderDate(Date orderDate) {this.orderDate = orderDate;}

    public int getShipping() {return shipping;}

    public void setShipping(int shipping) {this.shipping = shipping;}

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<CartLineInfo> getCartLines() {
        return this.cartLines;
    }

    private CartLineInfo findLineByCode(String code) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getProductInfo().getCode().equals(code)) {
                return line;
            }
        }
        return null;
    }

    public void addProduct(ProductInfo productInfo, int quantity) {
        CartLineInfo line = this.findLineByCode(productInfo.getCode());

        if (line == null) {
            line = new CartLineInfo();
            line.setQuantity(0);
            line.setProductInfo(productInfo);
            this.cartLines.add(line);
        }
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.cartLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }

    public void validate() {

    }

    public void updateProduct(String code, int quantity) {
        CartLineInfo line = this.findLineByCode(code);

        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                if (line.getProductInfo().getStock()-quantity >= 0)
                    line.setQuantity(quantity);
            }
        }
    }

    public void updateTVA(ProductInfo productInfo, double tva) {
        CartLineInfo line = this.findLineByCode(productInfo.getCode());

        if (line != null) {
            line.setTVA(tva);
        }
    }

    public void removeProduct(ProductInfo productInfo) {
        CartLineInfo line = this.findLineByCode(productInfo.getCode());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }

    public boolean isEmpty() {
        return this.cartLines.isEmpty();
    }

    public boolean isValidCustomer() {
        return this.customerInfo != null && this.customerInfo.isValid();
    }

    public int getQuantityTotal() {
        int quantity = 0;
        for (CartLineInfo line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }

    public double getTVATotal() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getTVA();
        }
        return total;
    }

    public double getAmountSubTotal() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getAmount();
        }
        return total;
    }

    public double getAmountTotal() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getTVA();
        }
        total += shipping;
        return total;
    }

    public void updateQuantity(CartInfo cartForm) {
        if (cartForm != null) {
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines) {
                this.updateProduct(line.getProductInfo().getCode(), line.getQuantity());
            }
        }

    }

    public void updateShipping(CartInfo cartForm) {
        if (cartForm != null) {
            this.setShipping(cartForm.shipping);
        }

    }

}
