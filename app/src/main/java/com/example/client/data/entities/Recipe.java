package com.example.client.data.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "recipe_table")
public class Recipe {

         /*
         * TODO skoða many to many relationship við cookbook
         */
        @PrimaryKey(autoGenerate = true)
        private int id;
        private String index;
        private String title;
        private String instructions;
        private double rating;
        private String image;
        private int readyInMin;
        private int servings;
        @Ignore
        private ArrayList<String> ingredients;
        private boolean fullInfo = false;

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    /*
            TODO pæla í hvort id komi inn her eða verði autogen
             */
        public Recipe(String title, int id, String image){
            this.title=title;
            this.id=id;
            this.image=image;
        }

        public boolean isFullInfo() {
            return fullInfo;
        }

        public void setFullInfo(boolean fullInfo) {
            this.fullInfo = fullInfo;
         }

        public void setIndex(String index) {
            this.index = index;
        }

        public void setIndex(int i){
            this.index=""+i;
        }

        public String getIndex(){
            return this.index;
        }

        public void setId(int id){
            this.id=id;
        }

        public Integer getId(){
            return this.id;
        }

        public void setTitle(String title){
            this.title=title;
        }

        public String getTitle(){
            return this.title;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public double getRating() {
            return rating;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImage(){
            return this.image;
        }

        public void setReadyInMin(int rinmin){
            this.readyInMin=rinmin;
        }

        public int getReadyInMin() {
            return readyInMin;
        }

        public void setInstructions(String instructions) {
            this.instructions = instructions;
        }

        public String getInstructions(){
            return this.instructions;
        }

        public void setServings(int servings) {
            this.servings = servings;
        }
        public int getServings(){
        return this.servings;
    }
     /*   public void setIngredients(ArrayList<String> ingredients) {
            this.ingredients = ingredients;
        }

        public ArrayList<String> getIngredients() {
            return ingredients;
        }
*/
        @Override
        public String toString(){
            String s = "Title: "+this.title;
            return s;
        }

}
