package uz.customs.customsprice.service;


import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Tnved2;
import uz.customs.customsprice.repository.Tnved2Repo;

@Service
public class Tnved2Service {
    private final Tnved2Repo tnved2Repo;

    public Tnved2Service(Tnved2Repo tnved2Repo) {
        this.tnved2Repo = tnved2Repo;
    }

    public Tnved2 getByIdAndFinishdate(String id) {
        if (tnved2Repo.findById(id).isPresent())
            return tnved2Repo.findById(id).get();
        else return null;
    }
}
