package uz.customs.customsprice.repository.CostMonitoring;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.customs.customsprice.entity.CostMonitoring.MtcReplEntity;

import javax.persistence.Entity;
import java.util.Date;

public interface MtcReplRepository extends JpaRepository<MtcReplEntity, String> {
    @Query("SELECT c FROM MtcReplEntity c WHERE" +
            "(:g7a='' or :g7a is null or c.g7A = :g7a) and"+
            "(:gdvipdate1 is null or c.gdvipdate >= :gdvipdate1) and"+
            "(:gdvipdate2 is null or c.gdvipdate <= :gdvipdate2) and"+
            "(:g11='' or :g11 is null or lower(c.g11) like lower(CONCAT('%',:g11,'%')) ) and"+
            "(:g15='' or :g15 is null or lower(c.g15) like lower(CONCAT('%',:g15,'%')) ) and"+
            "(:g34='' or :g34 is null or lower(c.g34) like lower(CONCAT('%',:g34,'%')) ) and"+
            "(:g33='' or :g33 is null or lower(c.g33) like lower(CONCAT('%',:g33,'%')) ) and"+
            "(:g31name='' or :g31name is null or lower(c.g31Name) like lower(CONCAT('%',:g31name,'%')) ) and"+
            "(:g25='' or :g25 is null or lower(c.g25) like lower(CONCAT('%',:g25,'%')) ) and"+
            "(:g8code2='' or :g8code2 is null or lower(c.g8Code2) like lower(CONCAT('%',:g8code2,'%')) ) and"+
            "(:metod_otc='' or :metod_otc is null or lower(c.metodOtc) like lower(CONCAT('%',:metod_otc,'%')) ) and"+
            "(:g20b='' or :g20b is null or lower(c.g20B) like lower(CONCAT('%',:g20b,'%')) ) and"+
            "(:g20name='' or :g20name is null or lower(c.g20Name) like lower(CONCAT('%',:g20name,'%')) ) and"+
            "(:g7c='' or :g7c is null or lower(c.g7C) like lower(CONCAT('%',:g7c,'%')) ) ")
    Page<MtcReplEntity> findAllByCmdtIdAndDeclId(
            @Param("g7a") String g7a,
            @Param("gdvipdate1") Date gdvipdate1,
            @Param("gdvipdate2") Date gdvipdate2,
            @Param("g11") String g11,
            @Param("g15") String g15,
            @Param("g34") String g34,
            @Param("g33") String g33,
            @Param("g31name") String g31name,
            @Param("g25") String g25,
            @Param("g8code2") String g8code2,
            @Param("metod_otc") String metod_otc,
            @Param("g20b") String g20b,
            @Param("g20name") String g20name,
            @Param("g7c") String g7c,
            Pageable paging
    );
}
