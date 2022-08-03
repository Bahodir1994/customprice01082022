package uz.customs.customsprice.service.statisticService;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.customs.customsprice.entity.statistics.tst.Transaction;
import uz.customs.customsprice.repository.statisticRepo.TransactionRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public void importToDb(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            List<Transaction> transactions = new ArrayList<>();
            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

                    XSSFSheet sheet = workBook.getSheetAt(0);
                    // looping through each row
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) - 1; rowIndex++) {
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }
                        String senderId = getValue(row.getCell(0)).toString();
                        String receiverId = getValue(row.getCell(1)).toString();
                        String initiatorId = getValue(row.getCell(2)).toString();
                        String bankCode = row.getCell(3).toString();
                        String serviceCode = row.getCell(4).toString();
                        String transactionAmount = row.getCell(5).toString();
                        String feeAmount = row.getCell(6).toString();

//                        Transaction transaction = Transaction.builder().senderId(String.valueOf(senderId)).receiverId(String.valueOf(receiverId))
//                                .initiatorId(String.valueOf(initiatorId)).bankCode(bankCode).serviceCode(String.valueOf(serviceCode))
//                                .trxnAmount(String.valueOf(transactionAmount)).feeAmount(String.valueOf(feeAmount)).build();
//                        transactions.add(transaction);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            if (!transactions.isEmpty()) {
                // save to database
                transactionRepository.saveAll(transactions);
            }
        }
    }

    private Object getValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case ERROR:
                return cell.getErrorCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return null;
            case _NONE:
                return null;
            default:
                break;
        }
        return null;
    }

    public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
        int numOfNonEmptyCells = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                XSSFCell cell = row.getCell(columnIndex);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    numOfNonEmptyCells++;
                }
            }
        }
        return numOfNonEmptyCells;
    }
}