package uz.customs.customsprice.service.statisticService;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TransactionService {

    void importToDb(List<MultipartFile> multipartfiles);

}