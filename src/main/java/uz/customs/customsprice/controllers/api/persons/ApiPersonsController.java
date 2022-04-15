package uz.customs.customsprice.controllers.api.persons;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.customs.customsprice.entity.InitialDecision.Persons;
import uz.customs.customsprice.service.PersonsService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/personsrestapi")
public class ApiPersonsController {
    private final PersonsService personsService;

    public ApiPersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @PostMapping
    public ResponseEntity<Object> valuesave(@RequestBody @Valid Persons persons, BindingResult br) {

        Map<String, String> errors = new HashMap<>();
        Map<String, Map<String, String>> AllErrors = new HashMap<>();

        Persons personsPinGet = personsService.getByPin(persons.getPin());
        Persons personsTinGet = personsService.getByTin(persons.getTin());
        Persons personsEmailGet = personsService.getByeMail(persons.getEmail());

        if (personsPinGet == null && personsTinGet == null && personsEmailGet == null) {
            if (br.hasErrors()) {
                errors = br.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
                JSONObject obj = new JSONObject();
                obj.put("message", "Error");
                obj.put("errors", errors);
                obj.put("status", "400");
                return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
            }
            personsService.savepersons(persons);
            JSONObject obj = new JSONObject();
            obj.put("message", "Success");
            obj.put("data", persons);
            obj.put("status", "200");
            ResponseEntity.status(0);
            return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
        } else {
            Persons AllUniqueParametrs = personsService.getByEmailAndPinAndTin(persons.getEmail(), persons.getPin(), persons.getTin());
            if(AllUniqueParametrs != null) {
                JSONObject obj = new JSONObject();
                obj.put("message", "Success");
                obj.put("data", personsPinGet);
                obj.put("status", "207");
                return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
            }
            JSONObject obj = new JSONObject();
            obj.put("message", "Error");
            obj.put("data", "Маълумотлар мос келмади");
            obj.put("status", "207");
            return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
        }
    }
}