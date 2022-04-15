package sbs.projects.beans;

import java.io.ObjectInputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by SherZod on 20.04.2018.
 */

public class Servlet {

    public static Object getObject(String host, int port, String address, String params) {
        URL dataURL = null;
        Object obj = null;
        try {
            String protocol = "http";
            dataURL = new URL(protocol, host, port, address + params);
            URLConnection connection = dataURL.openConnection();
            connection.setUseCaches(false);
            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
            obj = in.readObject();
            in.close();
            return obj;
        } catch (Exception e) {
            return e;
        }
    }


    public static void main(String[] args) {


        userParam up = null;
        String address1 = "asod";

        String address = "/" + address1 + "/getRights.jsp";
        String host = "192.168.214.122";
        String portS = "9080";
        int port = Integer.parseInt(portS);
        Object in = null;

//        <li><a href="#" onclick="openasod('http://192.168.214.109:9080/report/logon.do?address=asod&url=192.168.214.122&port=9080&uid=172610000071546','report');">
//        <li><a href="#" onclick="openasod('http://192.168.214.109:9080/report/logon.do?address=asod&url=192.168.214.122&port=9080&uid=172710000072332

        //http://192.168.214.109:9080/report/logon.do?address=asod&url=192.168.12.155&port=80&uid=AbdullaxodjayevAX

        in = getObject(host, port, address, "?uid=172710000072332");
        if ((in instanceof userParam)) {
            up = (userParam) in;
            System.out.println(up.getProUserFirstname());
            System.out.println(up.getUserRole());
            //INSPECTOR
            //ADMIN_POST
            //ADMIN_UGTK

        } else {
            System.out.println(up);

        }


    }

}

