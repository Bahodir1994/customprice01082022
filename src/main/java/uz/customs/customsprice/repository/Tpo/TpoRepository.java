package uz.customs.customsprice.repository.Tpo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.TPO.Tpo;

import java.util.Date;


public interface TpoRepository extends JpaRepository<Tpo, String> {
    Tpo findByG3AAndG3BAndG3C(String g3A, Date g3B, String g3C);
}
