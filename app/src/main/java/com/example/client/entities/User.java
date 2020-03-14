package com.example.client.entities;

public class User {

    private long id;
    private String userName;
    private String email;
    private String password;
    private CookBook cookbook;
    private Schedule schedule;
    private ShoppingList shoppingList;

    public static String getString() {
        return ("Hello user entity");
    }
}
