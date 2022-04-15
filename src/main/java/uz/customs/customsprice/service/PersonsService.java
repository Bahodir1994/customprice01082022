package uz.customs.customsprice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Persons;
import uz.customs.customsprice.repository.PersonsRepo;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class PersonsService {

    @Autowired
    public EntityManager entityManager;

    private final PersonsRepo personrepo;

    public PersonsService(PersonsRepo personrepo) {
        this.personrepo = personrepo;
    }

    public Persons savepersons(Persons persons){
        return personrepo.save(persons);
    }

    public Persons getByPin(String pin){
        return personrepo.findByPin(pin);
    }

    public Persons getByTin(String tin) {
        return personrepo.findByTin(tin);
    }

    public Persons getByeMail(String email) { return personrepo.findByEmail(email);}

    public Optional<Persons> getById(String id){return personrepo.findById(id);}

    public Persons getByEmailAndPinAndTin(String email, String pin, String tin){ return personrepo.findByEmailAndPinAndTin(email, pin, tin);}
}
