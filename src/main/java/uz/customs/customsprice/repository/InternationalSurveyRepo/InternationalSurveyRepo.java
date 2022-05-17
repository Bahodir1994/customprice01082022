package uz.customs.customsprice.repository.InternationalSurveyRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.controllers.InternationalSurvey.InternationalSurveyController;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;

@Repository
public interface InternationalSurveyRepo extends JpaRepository<InternationalSurveyEntity, String> {
}
