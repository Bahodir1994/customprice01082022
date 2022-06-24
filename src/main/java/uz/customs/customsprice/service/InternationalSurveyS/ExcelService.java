package uz.customs.customsprice.service.InternationalSurveyS;

import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.repository.InternationalSurveyRepo.InternationalSurveyRepo;

@Service
public class ExcelService {
    @Autowired
    InternationalSurveyRepo repository;

    @Autowired
    InternationalSurveyService internationalSurveyService;

    public ByteArrayInputStream load(String userLocation,String FromStart,String ToEnd) {
//        List<InternationalSurveyEntity> tutorials = internationalSurveyService.getInternationalSurveyReport(userLocation, Date.valueOf(FromStart), Date.valueOf(ToEnd));
        List<InternationalSurveyEntity> tutorials = repository.findAllByExecutiveTerritoryCodeAndXbbMailDateBetween(userLocation, Date.valueOf(FromStart), Date.valueOf(ToEnd));
        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials, FromStart, ToEnd);
        return in;
    }
}