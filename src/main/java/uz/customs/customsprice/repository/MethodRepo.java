package uz.customs.customsprice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Method;

import java.util.Optional;

public interface MethodRepo extends JpaRepository<Method, String> {
    Optional<Method> findById(String id);
}
