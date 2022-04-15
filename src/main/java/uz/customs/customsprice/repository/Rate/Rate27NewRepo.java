package uz.customs.customsprice.repository.Rate;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.Rate.Rate27New;

public interface Rate27NewRepo extends JpaRepository<Rate27New, Integer> {
    Rate27New findByTnved(String tnved);
}
