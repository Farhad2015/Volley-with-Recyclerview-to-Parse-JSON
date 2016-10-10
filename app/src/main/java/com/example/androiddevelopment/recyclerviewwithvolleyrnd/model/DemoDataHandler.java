package com.example.androiddevelopment.recyclerviewwithvolleyrnd.model;

/**
 * Created by Android Development on 10/9/2016.
 */

public class DemoDataHandler {
    String username;
    String email;
    String Address;

    public DemoDataHandler() {
    }

//    public DemoDataHandler(String username, String email, String address) {
//        this.username = username;
//        this.email = email;
//        Address = address;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
