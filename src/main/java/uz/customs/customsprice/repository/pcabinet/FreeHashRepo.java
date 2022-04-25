package uz.customs.customsprice.repository.pcabinet;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.Digests.FreehashEntity;

public interface FreeHashRepo extends JpaRepository<FreehashEntity, String> {
    FreehashEntity findByHash(String hash);
}
