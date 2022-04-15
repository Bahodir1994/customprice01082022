package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.Digests.QiymatconsultEntity;

import java.util.Optional;

public interface QiymatconsultRepo extends JpaRepository<QiymatconsultEntity, String> {
    QiymatconsultEntity findAllById(String id);
}
