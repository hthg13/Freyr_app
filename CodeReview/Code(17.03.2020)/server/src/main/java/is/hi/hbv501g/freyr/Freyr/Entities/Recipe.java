package is.hi.hbv501g.freyr.Freyr.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    private Integer id;
    private String index;
    private String title;
    @Column(columnDefinition = "VARCHAR(100000)")   // make sure the column is big enough
    private String instructions;
    private double rating;
    private String image;
    private int readyInMinutes;
    private int servings;
    @Column(columnDefinition = "VARCHAR(100000)")   // make sure the column is big enough
    private ArrayList<String> ingredients = new ArrayList<String>();
    private boolean fullInfo = false;
    public Recipe() {
    }

    public Recipe(String title, Integer id, String image) {
        this.title = title;
        this.id = id;
        this.image = image;
    }

    public void setFullInfo(){
        this.fullInfo=true;
    }

    public boolean getFullInfo(){
        return this.fullInfo;
    }

    public String getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = ""+i;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;

    }

    public void setIngredients(String ingredients) {
        this.ingredients.add(ingredients);
    }

    public ArrayList<String> getIngredients(){
        return this.ingredients;
    }

    @Override
    public String toString(){
        String s = "ID: "+this.id+"  Title: "+this.title;
        return s;
    }

}
