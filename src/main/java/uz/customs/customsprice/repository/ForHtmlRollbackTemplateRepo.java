package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.files.ForHtmlRollbackTemplate;

public interface ForHtmlRollbackTemplateRepo extends JpaRepository<ForHtmlRollbackTemplate, String> {

}
