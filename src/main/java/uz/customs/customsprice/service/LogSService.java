package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Log;
import uz.customs.customsprice.repository.LogRepo;

@Service
public class LogSService {
    private final LogRepo logRepo;

    public LogSService(LogRepo logRepo) {
        this.logRepo = logRepo;
    }

    public Log saveLog(Log log) {
        return logRepo.save(log);
    }
}
