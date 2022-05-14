package uz.customs.customsprice.repository.classifier;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Country;
import uz.customs.customsprice.entity.InitialDecision.Location;
import uz.customs.customsprice.entity.InitialDecision.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, String> {
    Post findByCode(String code);

    List<Post> findAllByCodeStartingWithAndLngaTpcd(String locationId, String lngaTpcd);
}
