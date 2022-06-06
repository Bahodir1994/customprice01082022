package uz.customs.customsprice.repository.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.gtdHistory.DeclarationEntity;

@Repository
public interface GTDHistoryRepo extends JpaRepository<DeclarationEntity, String> {
}
