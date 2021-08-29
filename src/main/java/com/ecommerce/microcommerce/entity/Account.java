package com.ecommerce.microcommerce.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account implements Serializable {

    private static final long serialVersionUID = -2054386655979281969L;

    @Id
    @Column(name = "User_Name", length = 20, nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "Active", length = 1, nullable = false)
    private boolean active;

    @Column(name = "User_Amount", nullable = false)
    private int amount;

    @Column(name = "User_Address", length = 255, nullable = false)
    private String userAddress;

    @Column(name = "User_Role", length = 30, nullable = false)
    private String userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAmount() { return amount; }

    public void setAmount(int amount) {this.amount = amount;}

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserRole() {return userRole;}

    public void setUserRole(String userRole) {this.userRole = userRole;}

    @Override
    public String toString() {
        return "[" + this.userName + "," + this.encrytedPassword + "," + this.amount + "]";
    }

}
