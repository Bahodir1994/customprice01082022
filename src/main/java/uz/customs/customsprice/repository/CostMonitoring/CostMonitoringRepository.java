package uz.customs.customsprice.repository.CostMonitoring;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.CostMonitoring.MtcRepl;

public interface CostMonitoringRepository extends JpaRepository<MtcRepl, String> {
}
