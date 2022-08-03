package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.files.ForHtmlCancelled;

public interface ForHtmlCancelledRepo extends JpaRepository<ForHtmlCancelled, String> {

}
