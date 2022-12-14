package uz.customs.customsprice.repository.earxiv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.earxiv.DBFile;

@Repository
public interface DBFileRepo extends JpaRepository<DBFile, String> {
    DBFile findByHash(String hash);
}