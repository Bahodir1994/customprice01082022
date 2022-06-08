package uz.customs.customsprice.service.InternationalSurveyS;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.repository.InternationalSurveyRepo.InternationalSurveyRepo;

@Service
public class InternationalSurveyService {
    private final InternationalSurveyRepo internationalSurveyRepo;

    public InternationalSurveyService(InternationalSurveyRepo internationalSurveyRepo) {
        this.internationalSurveyRepo = internationalSurveyRepo;
    }

    public InternationalSurveyEntity savingValue(InternationalSurveyEntity internationalSurveyEntity){
        return internationalSurveyRepo.save(internationalSurveyEntity);
    }

    public InternationalSurveyEntity getById(String id){
        if (internationalSurveyRepo.findById(id).isPresent()){
            return internationalSurveyRepo.findById(id).get();
        } else return null;
    }

    public InternationalSurveyEntity getByIdAndStatus(String id, String status){
        if (internationalSurveyRepo.findByIdAndStatus(id, status) != null){
            return internationalSurveyRepo.findByIdAndStatus(id, status);
        } else return null;
    }
}
