package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.files.forHtml;
import uz.customs.customsprice.entity.files.forHtmlCancelled;

import java.util.Optional;

public interface ForHtmlCancelledRepo extends JpaRepository<forHtmlCancelled, String> {

}
