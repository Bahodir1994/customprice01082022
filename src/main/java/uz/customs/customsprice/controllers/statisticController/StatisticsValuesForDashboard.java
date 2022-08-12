package uz.customs.customsprice.controllers.statisticController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.customs.customsprice.controllers.indec.DTO.FilterDTO;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.entity.users.User;
import uz.customs.customsprice.repository.InternationalSurveyRepo.InternationalSurveyRepo;
import uz.customs.customsprice.service.UserService;
import uz.customs.customsprice.service.apps.AppsService;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dashboardStatistics")
public class StatisticsValuesForDashboard {
    private final AppsService appsService;
    private final InternationalSurveyRepo inter;
    private final UserService userService;

    private final String DASHBOARDSTATISTICS = "/resources/pages/home/dashboardStatistics";

    public StatisticsValuesForDashboard(AppsService appsService, InternationalSurveyRepo inter, UserService userService) {
        this.appsService = appsService;
        this.inter = inter;
        this.userService = userService;
    }

    @PostMapping(value = DASHBOARDSTATISTICS)
    public ResponseEntity<Object> findByStatusAndLocationIdAndAppDateBetween(@RequestBody FilterDTO filterDTO) {
        try {
            List<Apps> apps = new ArrayList<>();
            apps = appsService.getAllApps();
            String appsSize = String.valueOf(apps.size()) + " та";

            List<InternationalSurveyEntity> internationalSurveyEntity = new ArrayList<>();
            internationalSurveyEntity = inter.findAll();
            BigDecimal sum = BigDecimal.valueOf(0.00);
            DecimalFormat df = new DecimalFormat("#,###.00");
            for (int i = 0; i < internationalSurveyEntity.size(); i++) {
                if (internationalSurveyEntity.get(i).getSumOnControl() != null) {
                    sum = sum.add(internationalSurveyEntity.get(i).getSumOnControl());
                }
            }

            String SizeInterSurvay = internationalSurveyEntity.size() + " та";

            List<User> userList = new ArrayList<>();
            userList = userService.getAllUser();


            Map<String, Object> response = new HashMap<>();
            response.put("appsSize", appsSize);
            response.put("sumInterSurvay", df.format(sum));
            response.put("SizeInterSurvay", SizeInterSurvay);
            response.put("userList", userList.size());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception ee){
            return new ResponseEntity<>("response", HttpStatus.BAD_REQUEST);
        }

    }

}
