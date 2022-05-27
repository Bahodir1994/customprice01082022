package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.StatusH;
import uz.customs.customsprice.entity.earxiv.Earxiv;

public interface StatusHRepo extends JpaRepository<StatusH, String> {
    Page<StatusH> findByAppId(String appId, Pageable pageable);
}
