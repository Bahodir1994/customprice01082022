package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.earxiv.Earxiv;

import java.util.List;

@Repository
public interface EarxivRepo extends JpaRepository<Earxiv, String> {

    List<Earxiv> findByAppId(String appId);

    Earxiv findByHashAndFileId(String hash, String fileId);

}
