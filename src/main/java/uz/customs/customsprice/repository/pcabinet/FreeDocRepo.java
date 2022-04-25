package uz.customs.customsprice.repository.pcabinet;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.Digests.FreedocEntity;

public interface FreeDocRepo extends JpaRepository<FreedocEntity, String> {
    FreedocEntity findByDeclIdAndAndDocType(String declId, String docType);
}
