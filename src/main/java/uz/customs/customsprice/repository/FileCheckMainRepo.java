package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.logcontrol.FileCrosCheckMain;

public interface FileCheckMainRepo extends JpaRepository<FileCrosCheckMain, String> {
    FileCrosCheckMain findByFlkId(String id);
}
