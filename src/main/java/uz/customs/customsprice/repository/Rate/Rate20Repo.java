package uz.customs.customsprice.repository.Rate;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.Rate.Rate20;

public interface Rate20Repo extends JpaRepository<Rate20, Integer> {
    Rate20 findByTnvedAndFinishDateIsNull(String tnved);
}
