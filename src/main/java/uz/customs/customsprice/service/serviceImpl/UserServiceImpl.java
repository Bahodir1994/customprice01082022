package uz.customs.customsprice.service.serviceImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.customs.customsprice.entity.users.User;
import uz.customs.customsprice.repository.UserRepository;
import uz.customs.customsprice.service.UserService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public static String randomCode() {
        UUID uuid = UUID.randomUUID();
        long lo = uuid.getLeastSignificantBits();
        long hi = uuid.getMostSignificantBits();
        lo = (lo >> (64 - 31)) ^ lo;
        hi = (hi >> (64 - 31)) ^ hi;
        String s = String.format("%010d", Math.abs(hi) + Math.abs(lo));
        return s.substring(s.length() - 14);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(String id, User user) {
        User user1 = userRepository.findById(id).get();
        user1.setUsername(user.getUsername());
        user1.setNotification(user.getNotification());
        return userRepository.save(user1);
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean deleteUser(String id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public void deleteAllUser() {
        userRepository.deleteAll();
    }

    @Override
    public boolean checkUser(String password, String enterPassword) {
        return bCryptPasswordEncoder.matches(enterPassword, password);
    }

    @Override
    public Boolean deleteUserById(String userId) {
        userRepository.deleteById(userId);
        return true;
    }
}
