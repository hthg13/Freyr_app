package is.hi.hbv501g.freyr.Freyr.Repositories;

import is.hi.hbv501g.freyr.Freyr.Entities.Recipe;
import is.hi.hbv501g.freyr.Freyr.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // ATH AÐFERÐIRNAR SEM ERU COMMENTAÐAR ÚT HÉR ER EKKI HÆGT AÐ HAFA Í REPOINU
    // ÞETTA ERU AÐFERÐIR SEM ÞARF AÐ ÚTFÆRA Í SERVICE IMPLEMENTATION SÉRSTAKLEGA
    // ... held ég kv helga

    User save(User user);
    void delete(User user);
    Optional<User> findById(Long id);
    List<User> findAll(); // bætti þessu við til prufu
    User findByUserName(String userName);
    //void updateFavorite(User user, Integer recipeId);

    //Boolean validate(long id, String password);
    //ArrayList<Recipe> getFavorites(String title);
    //void changePassword(User user, String newPassword);
}
