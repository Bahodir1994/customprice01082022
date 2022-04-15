package uz.customs.customsprice.service;



import uz.customs.customsprice.entity.InitialDecision.Log;
import uz.customs.customsprice.payload.ActivUserCount;

import javax.servlet.http.HttpServletRequest;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public interface LogService {

    Log create(HttpServletRequest request, String pnfl, int check) throws SocketException, UnknownHostException;

    Log getCarrierById(String id);

    List<Log> getAllLog();

    boolean deleteLog(String id);

    ActivUserCount count();

    Integer activeCount();

    List<Log> getByAplcPnflId(String ip);

}
