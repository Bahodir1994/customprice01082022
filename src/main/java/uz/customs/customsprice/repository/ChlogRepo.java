package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Chlog;

public interface ChlogRepo extends JpaRepository<Chlog, String> {
}
