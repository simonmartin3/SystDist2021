package com.ecommerce.microcommerce.form;

import com.ecommerce.microcommerce.entity.Account;
import com.ecommerce.microcommerce.model.CustomerInfo;

public class CustomerForm {

    private String username;
    private String lastname;
    private String address;
    private String city;
    private int zip;

    private boolean valid;

    public CustomerForm() {

    }

    public CustomerForm(CustomerInfo customerInfo) {
        if (customerInfo != null) {
            this.username = customerInfo.getUsername();
            this.lastname = customerInfo.getLastname();
            this.address = customerInfo.getAddress();
            this.city = customerInfo.getCity();
            this.zip = customerInfo.getZip();
        }
    }

    public CustomerForm(Account account) {
        if (account != null) {
            this.username = account.getUserName();
            this.lastname = account.getLastName();
            this.address = account.getAddress();
            this.city = account.getCity();
            this.zip = account.getZip();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
