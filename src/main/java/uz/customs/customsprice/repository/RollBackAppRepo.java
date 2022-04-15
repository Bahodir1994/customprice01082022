package uz.customs.customsprice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.RollBackApp;

public interface RollBackAppRepo extends JpaRepository<RollBackApp, String> {
}
