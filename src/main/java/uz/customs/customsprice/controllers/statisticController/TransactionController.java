package uz.customs.customsprice.controllers.statisticController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uz.customs.customsprice.service.statisticService.TransactionService;

import java.util.List;

@RestController
@RequestMapping(path = "/apis")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(path = "/import")
    public void importTransactionsFromExcelToDb(@RequestPart(required = true) List<MultipartFile> files) {

        transactionService.importToDb(files);

    }
}