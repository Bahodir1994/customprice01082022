package uz.customs.customsprice.service.InternationalSurveyS;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.repository.InternationalSurveyRepo.InternationalSurveyRepo;

@Service
public class ExcelService {
    @Autowired
    InternationalSurveyRepo repository;
    public ByteArrayInputStream load() {
        List<InternationalSurveyEntity> tutorials = repository.findAll();
        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }
}