package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.files.forHtml;

import java.util.Optional;

public interface forHtmlRepo extends JpaRepository<forHtml, String> {

//    Optional<forHtml> findById(String id);
}
