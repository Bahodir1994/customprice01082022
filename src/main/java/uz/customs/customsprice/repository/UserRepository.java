package uz.customs.customsprice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.users.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
    List<User> findByLocationAndPost(String userLocation, String userPost);
}