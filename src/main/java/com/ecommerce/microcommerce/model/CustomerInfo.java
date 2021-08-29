package com.ecommerce.microcommerce.model;

import com.ecommerce.microcommerce.entity.Account;
import com.ecommerce.microcommerce.form.CustomerForm;

public class CustomerInfo {

    private String username;
    private String address;

    private boolean valid;

    public CustomerInfo() {

    }

    public CustomerInfo(Account account) {
        if (account != null) {
            this.username = account.getUserName();
            this.address = account.getUserAddress();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
