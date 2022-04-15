package uz.customs.customsprice.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.users.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByIdAndName(Long id, String name);
}
