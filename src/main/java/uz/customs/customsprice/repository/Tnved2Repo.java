package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Tnved2;

import java.util.Optional;

public interface Tnved2Repo extends JpaRepository<Tnved2, String> {
    Optional<Tnved2> findById(String id);
}
