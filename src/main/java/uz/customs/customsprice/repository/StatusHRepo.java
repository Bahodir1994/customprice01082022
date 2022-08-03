package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.customs.customsprice.entity.InitialDecision.StatusH;

import java.util.List;

public interface StatusHRepo extends JpaRepository<StatusH, String> {
    Page<StatusH> findByAppIdAndStatusIn(String appId, List<String> status, Pageable pageable);

    List<StatusH> findByAppId(String appId);

    @Query("select " +
            "sh.id," +
            "per.fullname" +
            " from StatusH sh left join User per on per.userid = sh.insUser where " +
            "sh.appId = :appId")
    List<StatusH> sfsdgtbgjk(@Param("appId")String appId);

    List<StatusH> findByStatusAndAppId(String status, String appId);

    List<StatusH> findByStatusAndId(String status, String Id);

    StatusH findTop1ByAppIdAndStatusOrderByInsTimeDesc(String appId, String status);
}
