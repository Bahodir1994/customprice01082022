package uz.customs.customsprice.repository.earxiv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.earxiv.EarxivInsert;

@Repository
public interface LogEarxivRepository extends JpaRepository<EarxivInsert, String> {
}