package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.logcontrol.FileCrosCheckMain;

import javax.transaction.Transactional;

public interface FileCheckMainRepo extends JpaRepository<FileCrosCheckMain, String> {
    FileCrosCheckMain findByFlkId(String id);

    @Transactional
    void deleteFileCrosCheckMainByFlkId(String id);
}
