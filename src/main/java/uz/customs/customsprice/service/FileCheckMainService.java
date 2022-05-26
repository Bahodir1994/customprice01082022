package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.logcontrol.FileCrosCheckMain;
import uz.customs.customsprice.repository.FileCheckMainRepo;

@Service
public class FileCheckMainService {
    private final FileCheckMainRepo fileCheckMainRepo;

    public FileCheckMainService(FileCheckMainRepo fileCheckMainRepo) {
        this.fileCheckMainRepo = fileCheckMainRepo;
    }

    public FileCrosCheckMain getByFlkId(String id){
        return fileCheckMainRepo.findByFlkId(id);
    }
}
