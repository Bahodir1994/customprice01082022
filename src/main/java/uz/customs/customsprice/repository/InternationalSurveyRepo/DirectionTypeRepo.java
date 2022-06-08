package uz.customs.customsprice.repository.InternationalSurveyRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InternationalSurveyEntity.DirectionType;

public interface DirectionTypeRepo extends JpaRepository<DirectionType, String> {
    DirectionType findByCode(String code);
}
