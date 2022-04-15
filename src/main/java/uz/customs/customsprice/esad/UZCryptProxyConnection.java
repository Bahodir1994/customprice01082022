package uz.etranzitin.esad;

import com.ibm.as400.util.BASE64Decoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Vector;

/**
 * Created by anvar on 20.10.2015.
 */
public class UZCryptProxyConnection {
    public String errorMessage = "";

    public byte[] data = null;

    public Vector<String> response;

    public UZCryptProxyConnection() {

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        UZCryptProxyConnection uc = new UZCryptProxyConnection();
        System.out.println("Verifying signature");
        /*if (uc.verify("http://192.168.15.135:9080/cgi-bin/dsbase.cgi/verifysignature", "019484", "C0C1F1F-534E0B63-4B595797-F50000041388643461734", "L6JHeTBC/xLCLQMSVTcRNl6RJB9dYNOiSE5VZpvFDMSnnJZRhGBkLHe91qI4vlA/icRELbRcgkvYjon+O69iXo9TFKsDdFpdg9dOa49J+NhXHOE3vElvoVKLO1aQ7A9/B+y9mH2lQmnHEBHUaJHR6RG5X0DFWOyJaq8baj6d0HQRBUuCxH1oNjqX1NTIvUwqmvNOzcuKsYq7kBnAFzXa6g==")){
            System.out.println("OK");
        } else{
            System.out.println("FAIL");
            System.out.println(uc.errorMessage);
        }*/

        if (uc.verify("http://192.168.15.135:9080/cgi-bin/dsbase.cgi/verifysignature", "122482", "1446101913932:01DE72:",
                "E7rP9O1j1KkN5fkSZKekU7qaCEUjl0A9Tqihho0yRcgZmhoE0AgACjI3cAXKykKUBqO/rxCnmsHolOnqxb+zufCFpiHUl9fft22eD5v85NnVExXphufu37AMWgLJfjoYfA7ABIeWpMDWOsrAeOfLQxxI4X2on18u+xKKQ0USgfRGF6WQ/n80QUdFfNAw2qiwJbWhcoyYr2fwYGgQlNItCw=="))
            System.out.println("ok");
        else {
            System.out.println("fail");
            System.out.println(uc.errorMessage);
        }

/*



        if(uc.verify("http://192.168.2.198:8080/cgi-bin/dsbase.cgi/verifysignature","01876A","12345678901231фывфы","LM6WQyRDSfk98rC3gPcZ5Xm2bNGqJ0c3HkFMYAeds7l8UpVa4/dA02k4FDW0Ah1rnxdMrBqNW0hP1AFQ3H8MWTZchUEbI3rAYGfeObxLmekAEuM3xiawvACOhViXN+TJ3Tbt2kp1NUMYKZFx6rOis7uhWSeqhAU/+t7hKJaf6nYQdnnO/fNhvWnlGuR4tvOb8K9wKoTenGXcq1kA+f/yUw==")){
            System.out.println("OK");
        }else{
            System.out.println("FAIL");
            System.out.println(uc.errorMessage);
        }
        System.out.println("Decrypting data and verifying signature");
        if(uc.decrypt("http://192.168.2.198:8080/cgi-bin/dsbase.cgi/decryptverifysignature","01876A","gAAAANqEfJt4LRnpoWHLtdwYM6+Gullu1Frj8dzzGSZk0U9FmQWG0T/CHMTGeCeoXOx/3pFDmam60wju5FxgHIzlE94B1TbIRUn3Es0byvmExRfJSuZlNu+QCF31t78dw3mbdSHBBsecPz0RZ6I2vUqWmksSSX12H1elhjNxuQXmRnJluwAAADj2Afsd28hLSjLf9gwRaOkG+WHFXMMl7cvA2P0qcY+HYc1sM7Z/wi1p/vvgysfVu7e3gRlmkXAAOqUUz9pW7tveOIH5CznEGlT/XGlfjqeQ+66UQ80F0ZwLBftSWWMlYi42so5AbEubQHROrTj60PGnGS6AuB2qDPDfowYE3gqXVfZAq+bqWu0K2h+4NBjARe8VAVVhdVBRQ92ZPgEZHveWi388tgobWLXECzVJS7cKgkzfnBVTzgilWYA=")){
            System.out.println("OK");
            System.out.println(new String(uc.data, "WINDOWS-1251"));
        }else{
            System.out.println("FAIL");
            System.out.println(uc.errorMessage);
        }
*/
    }

    public boolean verify2(String serial_number, String data, String signature, String certificate) {
        boolean result = false;
        try {
            String cmd = "C:\\chckERI\\chckERI.exe " + serial_number + " " + data + " " + signature + " " + certificate;
            String line;
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream(), "cp1251"));
            errorMessage = "";
            while ((line = input.readLine()) != null) {
                errorMessage += line;
                if (line.indexOf("SUCCESS") > -1) result = true;
            }
            input.close();
        } catch (Exception err) {
            System.out.println(err.getMessage());
            err.printStackTrace(System.out);
        }
        return result;
    }

    public boolean verify(String post_url, String serial_number, String data, String sign64) {
        try {
            // Construct data
            String pdata = URLEncoder.encode("serial_number", "WINDOWS-1251") + "=" + URLEncoder.encode(serial_number, "WINDOWS-1251");
            pdata += "&" + URLEncoder.encode("data", "WINDOWS-1251") + "=" + URLEncoder.encode(data, "WINDOWS-1251");
            pdata += "&" + URLEncoder.encode("signature", "WINDOWS-1251") + "=" + URLEncoder.encode(sign64, "WINDOWS-1251");

            // Send data
            URL url = new URL(post_url);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(pdata);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            response = new Vector<>();
            while ((line = rd.readLine()) != null) {
                response.add(line);
            }
            wr.close();
            rd.close();
            if (response.size() < 2) {
                errorMessage = "Ошибка ответа сервера";
                return false;
            }
            if (response.get(0).equals("SUCCESS")) {
                return true;
            } else {
                errorMessage = response.get(1);
                return false;
            }
        } catch (Exception e) {
            errorMessage = e.getMessage();
            return false;
        }
    }

    public boolean decrypt(String post_url, String serial_number, String cdata) {
        try {
            // Construct data
            String pdata = URLEncoder.encode("serial_number", "WINDOWS-1251") + "=" + URLEncoder.encode(serial_number, "WINDOWS-1251");
            pdata += "&" + URLEncoder.encode("encrypted_data", "WINDOWS-1251") + "=" + URLEncoder.encode(cdata, "WINDOWS-1251");

            // Send data
            URL url = new URL(post_url);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(pdata);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            response = new Vector<String>();
            while ((line = rd.readLine()) != null) {
                response.add(line);
            }
            wr.close();
            rd.close();
            if (response.size() < 2) {
                errorMessage = "Ошибка ответа сервера";
                return false;
            }
            if (response.get(0).equals("SUCCESS")) {
                BASE64Decoder dec = new BASE64Decoder();
                data = dec.decodeBuffer(response.get(1));
                return true;
            } else {
                errorMessage = response.get(1);
                return false;
            }
        } catch (Exception e) {
            errorMessage = e.getMessage();
            return false;
        }
    }
}
