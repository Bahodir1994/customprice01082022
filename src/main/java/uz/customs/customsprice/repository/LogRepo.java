package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Country;
import uz.customs.customsprice.entity.InitialDecision.Log;

public interface LogRepo extends JpaRepository<Log, String> {
}
