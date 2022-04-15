package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.IdNumber;

public interface IdNumberRepository extends JpaRepository<IdNumber, String> {
}
