package uz.customs.customsprice.repository.Rate;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.Rate.Rate20;
import uz.customs.customsprice.entity.Rate.Rate29;

public interface Rate29Repo extends JpaRepository<Rate29, Integer> {
    Rate29 findByTnved(String tnved);
}
