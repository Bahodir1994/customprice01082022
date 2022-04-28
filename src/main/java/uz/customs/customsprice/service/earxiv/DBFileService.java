package uz.customs.customsprice.service.earxiv;
import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.earxiv.DBFile;
import uz.customs.customsprice.repository.earxiv.DBFileRepo;

@Service
public class DBFileService {
    private final DBFileRepo dbFileRepo;

    public DBFileService(DBFileRepo dbFileRepo) {
        this.dbFileRepo = dbFileRepo;
    }

    public DBFile getByHash(String hash) {
        if (dbFileRepo.findByHash(hash) != null) {
            return dbFileRepo.findByHash(hash);
        } else return null;
    }




}
