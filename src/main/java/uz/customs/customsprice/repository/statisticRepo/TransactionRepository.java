package uz.customs.customsprice.repository.statisticRepo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.statistics.tst.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}