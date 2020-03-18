package is.hi.hbv501g.freyr.Freyr.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;
    private String email;
    private String password;

    //@ManyToMany
    //@JoinTable(name = "fav_recipes", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private ArrayList<Integer> favorite = new ArrayList<>();

    public User(Integer id, String userName, String email, String password, ArrayList<Integer> favorite) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.favorite = favorite;
    }

    public User(Integer id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public ArrayList<Integer> getFavorite() {
        return favorite;
    }

    public void setFavorite(ArrayList<Integer> favorite) {
        this.favorite = favorite;
    }

    public void addToFavorite(Integer id) {
        favorite.add(id);
    }
}
