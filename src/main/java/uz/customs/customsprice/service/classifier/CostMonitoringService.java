package uz.customs.customsprice.service.classifier;

import java.util.List;

public interface CostMonitoringService {
    List getCostMonitoring(String id);

    List getInitialDecision(String status);

    List getInitialDecisionView(int app_id);
}

