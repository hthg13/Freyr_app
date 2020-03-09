package is.hi.hbv501g.freyr.Freyr.Services.Implementations;

import is.hi.hbv501g.freyr.Freyr.Entities.Recipe;
import is.hi.hbv501g.freyr.Freyr.Entities.User;
import is.hi.hbv501g.freyr.Freyr.Repositories.UserRepository;
import is.hi.hbv501g.freyr.Freyr.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    UserRepository userRepo;

    @Autowired
    public UserServiceImplementation(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void changePassword(User user, String newPassword) {
        // todo útfæra þetta
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    // login method
    @Override
    public User validate(User user) {
        User exists = findByUserName(user.getUserName());
        if(exists != null){
            if(exists.getPassword().equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public User updateFavorite(User user, Integer recipeId) {
        User exists = userRepo.findByUserName(user.getUserName());
        if(exists != null){
            exists.getFavorite().add(recipeId);
            userRepo.save(exists);
            return exists;
        }

        return null;
    }

    /*@Override
    public ArrayList<Recipe> getFavorites(String title) {
        // todo útfæra þetta
        return null;
    }*/

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
