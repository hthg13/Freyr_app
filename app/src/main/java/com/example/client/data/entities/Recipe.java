package com.example.client.data.entities;

import java.util.ArrayList;

public class Recipe {

         /*
         * TODO gera þetta að room
         */

        private Integer id;
        private String index;
        private String title;
        private String instructions;
        private double rating;
        private String image;
        private int readyInMin;
        private int servings;
        private ArrayList<String> ingredients;
        private boolean fullInfo = false;

        public Recipe(String title, Integer id, String image){
            this.title=title;
            this.id=id;
            this.image=image;
        }

        public void setFullInfo(){
            this.fullInfo=true;
        }

        public boolean getFullInfo(){
            return this.fullInfo;
        }

        public void setIndex(int i){
            this.index=""+i;
        }

        public String getIndex(){
            return this.index;
        }

        public void setId(Integer id){
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

        public void setIngredients(ArrayList<String> ingredients) {
            this.ingredients = ingredients;
        }

        public ArrayList<String> getIngredients() {
            return ingredients;
        }

        @Override
        public String toString(){
            String s = "Title: "+this.title;
            return s;
        }

}
