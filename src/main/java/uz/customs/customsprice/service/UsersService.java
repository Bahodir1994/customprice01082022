package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.entity.users.User;
import uz.customs.customsprice.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getByLocationAndPostAndRole(String userLocation, String userPost, Integer userRole) {
        String queryList ="select\n" +
                "    *\n" +
                "from\n" +
                "    cpid.user_e u\n" +
                "left join\n" +
                "    cpid.user_e_urole ur\n" +
                "on\n" +
                "    u.id = ur.user_id\n" +
                "left join\n" +
                "    cpid.urole r\n" +
                "on\n" +
                "    ur.roles_id = r.id\n" +
                "where\n" +
                "    r.code= '"+ userRole +"'\n" +
                "and u.location= '" + userLocation + "' \n" +
                "and u.post = '"+ userPost +"' ";
        return (List<User>) entityManager.createNativeQuery(queryList, User.class).getResultList();
    }

    public Optional<User> getById(String id){
        return  userRepository.findById(id);
    }


}
