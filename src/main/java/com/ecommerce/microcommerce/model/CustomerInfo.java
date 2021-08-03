package com.ecommerce.microcommerce.model;

import com.ecommerce.microcommerce.entity.Account;
import com.ecommerce.microcommerce.form.CustomerForm;

public class CustomerInfo {

    private String username;
    private String lastname;
    private String address;
    private String city;
    private int zip;

    private boolean valid;

    public CustomerInfo() {

    }

    public CustomerInfo(CustomerForm customerForm) {
        this.username = customerForm.getUsername();
        this.lastname = customerForm.getLastname();
        this.address = customerForm.getAddress();
        this.city = customerForm.getCity();
        this.zip = customerForm.getZip();
        this.valid = customerForm.isValid();
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
