package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.InitialDecision.Persons;

import java.util.Optional;

@Repository
public interface PersonsRepo extends JpaRepository<Persons, String> {
    Persons findByPin(String pin);

    Persons findByTin(String tin);

    Persons findByEmail(String email);

    Optional<Persons> findById(String id);

    Persons findByEmailAndPinAndTin(String email, String pin, String tin);
}

