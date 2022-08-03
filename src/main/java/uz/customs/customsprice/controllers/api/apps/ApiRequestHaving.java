package uz.customs.customsprice.controllers.api.apps;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.service.InDecService;
import uz.customs.customsprice.service.person.PersonsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping()
public class ApiRequestHaving {
    private final PersonsService personsService;
    private final InDecService inDecService;

    public ApiRequestHaving(PersonsService personsService, InDecService inDecService) {
        this.personsService = personsService;
        this.inDecService = inDecService;
    }

    @GetMapping("/appsrequesthaving")
    public ResponseEntity<Map<String, Object>>valuesave(@RequestParam String inDecNum, @RequestParam String inDecDate, @RequestParam String personPin) throws ParseException {
        Map<String, String> errors = new HashMap<>();
        try{
            Date inDecDateValue = new SimpleDateFormat("dd.MM.yyyy").parse(inDecDate);
        }
         catch (Exception e) {
             JSONObject obj = new JSONObject();
             obj.put("message", "Error");
             obj.put("errors", "Sana formati noto'g'ri kiritildi!");
             obj.put("status", "400");
             return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
        }


        Date inDecDateValue = new SimpleDateFormat("dd.MM.yyyy").parse(inDecDate);
        Persons persons = new Persons();
        persons = personsService.getByPin(personPin);

        if (persons == null) {
            JSONObject obj = new JSONObject();
            obj.put("message", "Error");
            obj.put("errors", "Foydalanuvchi JSHSHIR raqami topilmadi");
            obj.put("status", "400");
            return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
        }



        if (inDecService.getByInDecNumAndInDecDateAndPersonId(inDecNum, inDecDateValue, persons.getId()) != null) {
            JSONObject obj = new JSONObject();
            obj.put("message", "Success");
            obj.put("data", true);
            obj.put("status", "200");
            ResponseEntity.status(0);
            return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
        } else {
            JSONObject obj = new JSONObject();
            obj.put("message", "Error");
            obj.put("errors", "Dastlabki qaror topilmadi!");
            obj.put("status", "400");
            return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
        }
    }

}
