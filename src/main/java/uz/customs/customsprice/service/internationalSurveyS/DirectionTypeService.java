package uz.customs.customsprice.service.internationalSurveyS;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InternationalSurveyEntity.DirectionType;
import uz.customs.customsprice.repository.InternationalSurveyRepo.DirectionTypeRepo;

@Service
public class DirectionTypeService {
    private final DirectionTypeRepo directionTypeRepo;

    public DirectionTypeService(DirectionTypeRepo directionTypeRepo) {
        this.directionTypeRepo = directionTypeRepo;
    }

    public DirectionType getByCode(String code){
        if (directionTypeRepo.findByCode(code) != null){
            return directionTypeRepo.findByCode(code);
        }
        return null;
    }

}
