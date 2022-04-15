package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.files.Docs;
import uz.customs.customsprice.repository.DocsRepo;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DocsService {

    private final DocsRepo docsRepo;

    public DocsService(DocsRepo docsRepo) {
        this.docsRepo = docsRepo;
    }

    public Docs savedocs(Docs docs) {
        return docsRepo.save(docs);
    }

    public Docs getByHash256(String hash256) {
        return docsRepo.findByHash256(hash256);
    }

    public Docs getByAppId(String appId) {
        return docsRepo.findTop1ByAppIdOrderByInsTimeDesc(appId);
    }

    public Optional<Docs> getById(String id){
        return  docsRepo.findById(id);
    }

    public List<Docs> getByAppIdForPdf(String appId){return  docsRepo.findByAppId(appId);}
}
