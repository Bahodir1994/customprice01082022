package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.customs.customsprice.entity.InitialDecision.TransportType;
import uz.customs.customsprice.entity.earxiv.Earxiv;

import java.util.List;

@Repository
public interface EarxivRepo extends JpaRepository<Earxiv, String> {

    List<Earxiv> findByAppId(String appId);

    Earxiv findByHashAndFileId(String hash, String fileId);

    Page<Earxiv> findByAppId(String appId, Pageable pageable);

    @Transactional
    void deleteAllByAppId(String appId);

}
