package com.example.faiz_faizal.simpleapps.model;

/**
 * Created by faiz-faizal on 7/11/2017.
 */

public class User {

    private int id;
    private String name;
    private String username;
    private String password;
    private String phone;

    //getter method
    public int getId(){return id;}
    public String getUsername(){return username;}
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public String getPassword(){return password;}

    //setter method

    public void setId (int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}
    public void setPhone(String phone){this.phone = phone;}




}
