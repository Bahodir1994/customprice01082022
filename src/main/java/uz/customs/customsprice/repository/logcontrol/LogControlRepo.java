package uz.customs.customsprice.repository.logcontrol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.customs.customsprice.entity.logcontrol.CroscheckMainEntity;

import java.util.Date;
import java.util.List;

public interface LogControlRepo extends JpaRepository<CroscheckMainEntity, String> {

    @Query("SELECT c FROM CroscheckMainEntity c WHERE" +
            " (:flkNum='' or :flkNum is null or lower(c.flkNum) like lower(CONCAT('%',:flkNum,'%'))) and" +
            " (:flkName='' or :flkName is null or lower(c.flkName) like lower(CONCAT('%',:flkName,'%'))) and" +
            " (:status='' or :status is null or c.status = :status) and"+
            " (:flkDep='' or :flkDep is null or c.flkDep = :flkDep) and"+
            " (:DfromRes is null or c.flkDate >= :DfromRes) and" +
            " (:DtooRes is null or c.flkDate <= :DtooRes)")
    List<CroscheckMainEntity>
    findByFlkNumAndFlkNameAndStatusAndFlkDepAndFlkDateBetween(
              @Param("flkNum")String flkNum,
              @Param("flkName")String flkName,
              @Param("status")String status,
              @Param("flkDep")String flkDep,
              @Param("DfromRes")Date DfromRes,
              @Param("DtooRes")Date DtooRes
    );

}
