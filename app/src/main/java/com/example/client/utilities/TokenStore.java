package com.example.client.utilities;

import android.content.SharedPreferences;

import com.example.client.data.entities.Recipe;
import com.example.client.data.entities.User;


import java.util.ArrayList;

public class TokenStore {

    private final static String TOKEN = "TOKEN";
    private final static String USER_ID = "USER_ID";
    private final static String USERNAME = "USER_NAME";
    private final static String USER_PW = "USER_PW";
    private final static ArrayList<Recipe> rs= new ArrayList<>();
    private final static ArrayList<String> ls= new ArrayList<>();

    public static String getToken(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(TOKEN,"");
    }

    public static void storeToken(SharedPreferences sharedPreferences, String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN, token);
        editor.apply();
    }

    public static void clearToken(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(TOKEN);
        editor.apply();
    }

    public static String getUserId(SharedPreferences sharedPreferences){
        return sharedPreferences.getString(USER_ID, "");
    }

    public static String getUserName(SharedPreferences sharedPreferences){
        return sharedPreferences.getString(USERNAME, "");
    }

    public static String getUserPw(SharedPreferences sharedPreferences){
        return sharedPreferences.getString(USER_PW, "");
    }

    public static void storeUser(SharedPreferences sharedPreferences, User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String username = user.getUserName();
        String password = user.getPassword();
        String userId = String.valueOf(user.getId());

        editor.putString(USERNAME, username);
        editor.putString(USER_ID, userId);
        editor.putString(USER_PW, password);
        editor.apply();
    }

    public static void clearUser(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(USER_ID);
        editor.apply();
    }


    public static void addRecipe(Recipe r){
        rs.add(r);
    }

    public static ArrayList<Recipe> getRecipes(){
        return rs;
    }

    public static void addI(String s){ls.add(s);}
    public static ArrayList<String> getList(){return ls;}
}
