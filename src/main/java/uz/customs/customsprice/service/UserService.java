package uz.customs.customsprice.service;

import uz.customs.customsprice.entity.users.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User save(User user);

    User update(String id, User user);

    List<User> getAllUser();

//    List<User> getAllUser(String userLocation, String userPost, Integer userRole);

    User getUserById(String id);

    User getUserByUsername(String username);

    boolean deleteUser(String id);

    void deleteAllUser();

    boolean checkUser(String password, String enterPassword);

    Boolean deleteUserById(String userId);
}