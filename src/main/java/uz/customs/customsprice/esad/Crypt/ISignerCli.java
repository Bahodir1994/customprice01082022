package uz.etranzitin.esad.Crypt;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISignerCli {
    private String cliPath;

    public ISignerCli(String cliPath) throws IOException {
        File f = new File(cliPath);
        if (f.exists() && !f.isDirectory()) {
            this.cliPath = cliPath;
        } else {
            throw new IOException("Cli executable file not exists: \"" + cliPath + "\"");
        }
    }

    private static String _exec(String[] cmd) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
        String res = "";
        try (BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String temp;
            while ((temp = input.readLine()) != null) {
                res += temp + "\n";
            }
        }
        if (process.exitValue() != 0) {
            throw new RuntimeException(res);
        }
//        System.out.println("_exec: " + res);
//        System.out.println();
//        for (int i = 0; i < cmd.length; i++) System.out.print(" " + cmd[i]);
//        System.out.println();
        return res.trim();
    }

    public static void main_old(String[] args) {

        String userCerAlg1B64 = "MIIFRDCCBIugAwIBAgIQOHEsVDxG6/6qz/USgWF3FDAPBgsqhlwDDwEBAQICAgUAMIGEMQswCQYDVQQGEwJVWjFJMEcGA1UECwxARVJJIGthbGl0bGFyaW5pIHJv4oCYeXhhdGdhIG9saXNoIG1hc" +
                "mthemkgKE/igJhaRFNUIDEwOTItMjAwOS1JKTEWMBQGA1UECgwNVU5JQ09OLlVaIERVSzESMBAGA1UEAwwJdW5pY29uLnV6MB4XDTE5MDUwNzExMjExNFoXDTIxMDUwNzExMjExNFowgYUxPDAJBgNVBAYTAlVaM" +
                "BQGByqGXAMQAQEMCTUxODk4NTQzNTAZBgcqhlwDEAECDA4zMTUwMjg5MTc4MTIyMTFFMEMGA1UEAww80KjQntCZ0JzQkNCg0JTQntCd0J7QkiDQoNCj0KHQotCQ0Jwg0KHQkNCq0JTQo9Cb0JvQntCV0JLQmNCnM" +
                "IIBpDAZBgkqhlwDDwEBAQEwDAYKKoZcAw8BAQEBAwOCAYUABIIBgID+dT25Fqf6L3v2+/UA4EwDIx5wuqvQPXiKEXim2wZKmS9vVLhCu+J24cDRtkfAwKIu9mTIY4KRCPh9cjoxMpX6yl3BRtpstpWRkqTrBo82j" +
                "NFizOqSqJ08f/YSYcW6swY2vBFPBpTsCO8qPSBq1gPqEWgCH9Qat8P5sskv05oAftLfc9zHJ3tPj3AI9YxKFmn5KZCPtHkAO9K5lB85B9a1SFPHYBUY70HAuoQBFn0gNWdT+5+O9E4udMMPxC126TpSgK4OoeiB/" +
                "cM9XpVaQB5jHRphvLkEewGCAyJUfVu7Udf/Vn3UVZOQ63eM27qjWrhCd+WnwF7TkUkAihTJD3BXx4yUFscPFOvX0MnddcmIOvjCUw8d6cII24ndw+PH7aS8dhshevGKME8ti6Uwoy/PFtXmsE/r9YsUIrq3CpvM5" +
                "RTzLVx5u+1S88ouV+wKCGb1kOIZ4XZKCghdIDAXCLOO3fpHpPm9RUdmhzVlVXSmm9wKQhH2HUv9iR4uIurfkqOCAYgwggGEMAkGA1UdEwQCMAAwMQYDVR0fBCowKDAmoCSgIoYgaHR0cDovL2NhLnVuaWNvbi51e" +
                "i91bmljb24tMS5jcmwwHQYDVR0OBBYEFHVmw13xsuf6scAVxaF7cd//bJ6LMIHABgNVHSMEgbgwgbWAFOQOajRd9sCPSI2TBzhu/jsKcWx/oYGKpIGHMIGEMQswCQYDVQQGEwJVWjFJMEcGA1UECwxARVJJIGthb" +
                "Gl0bGFyaW5pIHJv4oCYeXhhdGdhIG9saXNoIG1hcmthemkgKE/igJhaRFNUIDEwOTItMjAwOS1JKTEWMBQGA1UECgwNVU5JQ09OLlVaIERVSzESMBAGA1UEAwwJdW5pY29uLnV6ghABAAAAAAAAAHpoGu0rJ8ijM" +
                "GIGCCsGAQUFBwEBBFYwVDAsBggrBgEFBQcwAoYgaHR0cDovL2NhLnVuaWNvbi51ei91bmljb24tMS5jZXIwJAYIKwYBBQUHMAGGGGh0dHA6Ly9jYS51bmljb24udXovb2NzcDAPBgsqhlwDDwEBAQICAgUAA4GhA" +
                "EP37Ss6Oe9tge9JQSBL3vp1BwR2hLJk1RVq3pr+0aC2QAo7ZElR0zTK9d/1ReC4YO/b/ZLqIgBNvDGCavVSjU6JdBDUH6xFU3In5H1YPKqE5xBU7mp0cxn4tNgtehHc4NdrLzSuh+3+ZE8iBvIeu5cV1d/Bbcj5a" +
                "jKHnOP8WACVnmmVlZma4KhXULrHGKOX6nbf1rfMcB/MMVpPqtCv0F8=";
        String text = "C7E1-FFFF-6A07-21011593760580605";
        String textHash = "+6FWAiuudj4sX7uzfJ947R9MhOxA9SGJQ9a3AWvqBxg=";
        String tsignData = "NVt0SrSou9kKQ5f+IsDISE0B92PsThWm7m+afTguWSRAx3BdBqsanNYKslmb7R7UvCs/fxlYr9H1lsbcZenBj9hmJlbuS7xMH04gbYHnD08/CaD9A/J5605Ee4Y4yEjr4Mo+42Qs8gpdUh3A" +
                "WUsgPMsVWegSmf6yY3O17XSVG+MrhgPexiZtOunjf/t5bMB0T2rea4BSEarEnXTbydERmEkMLlffCwgetLPeYX326/4=";


        try {
            ISignerCli isigner = new ISignerCli("C:\\ERI\\isignercli.exe");
            long huserCerAlg1 = 0; //user cer handle
            if (!isigner.verifySignature(textHash, userCerAlg1B64, tsignData)) System.out.println("signature error");
//            System.out.println(isigner.checkERI(userCerAlg1B64, text, tsignData));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            e.printStackTrace(System.out);
        } finally {

        }
    }

    public static void main(String[] args) {

        String userCerAlg1B64 = "MIIFRDCCBIugAwIBAgIQOHEsVDxG6/6qz/USgWF3FDAPBgsqhlwDDwEBAQICAgUAMIGEMQswCQYDVQQGEwJVWjFJMEcGA1UECwxARVJJIGthbGl0bGFyaW5pIHJv4oCYeXhhdGdhIG9saXNoIG1hc" +
                "mthemkgKE/igJhaRFNUIDEwOTItMjAwOS1JKTEWMBQGA1UECgwNVU5JQ09OLlVaIERVSzESMBAGA1UEAwwJdW5pY29uLnV6MB4XDTE5MDUwNzExMjExNFoXDTIxMDUwNzExMjExNFowgYUxPDAJBgNVBAYTAlVaM" +
                "BQGByqGXAMQAQEMCTUxODk4NTQzNTAZBgcqhlwDEAECDA4zMTUwMjg5MTc4MTIyMTFFMEMGA1UEAww80KjQntCZ0JzQkNCg0JTQntCd0J7QkiDQoNCj0KHQotCQ0Jwg0KHQkNCq0JTQo9Cb0JvQntCV0JLQmNCnM" +
                "IIBpDAZBgkqhlwDDwEBAQEwDAYKKoZcAw8BAQEBAwOCAYUABIIBgID+dT25Fqf6L3v2+/UA4EwDIx5wuqvQPXiKEXim2wZKmS9vVLhCu+J24cDRtkfAwKIu9mTIY4KRCPh9cjoxMpX6yl3BRtpstpWRkqTrBo82j" +
                "NFizOqSqJ08f/YSYcW6swY2vBFPBpTsCO8qPSBq1gPqEWgCH9Qat8P5sskv05oAftLfc9zHJ3tPj3AI9YxKFmn5KZCPtHkAO9K5lB85B9a1SFPHYBUY70HAuoQBFn0gNWdT+5+O9E4udMMPxC126TpSgK4OoeiB/" +
                "cM9XpVaQB5jHRphvLkEewGCAyJUfVu7Udf/Vn3UVZOQ63eM27qjWrhCd+WnwF7TkUkAihTJD3BXx4yUFscPFOvX0MnddcmIOvjCUw8d6cII24ndw+PH7aS8dhshevGKME8ti6Uwoy/PFtXmsE/r9YsUIrq3CpvM5" +
                "RTzLVx5u+1S88ouV+wKCGb1kOIZ4XZKCghdIDAXCLOO3fpHpPm9RUdmhzVlVXSmm9wKQhH2HUv9iR4uIurfkqOCAYgwggGEMAkGA1UdEwQCMAAwMQYDVR0fBCowKDAmoCSgIoYgaHR0cDovL2NhLnVuaWNvbi51e" +
                "i91bmljb24tMS5jcmwwHQYDVR0OBBYEFHVmw13xsuf6scAVxaF7cd//bJ6LMIHABgNVHSMEgbgwgbWAFOQOajRd9sCPSI2TBzhu/jsKcWx/oYGKpIGHMIGEMQswCQYDVQQGEwJVWjFJMEcGA1UECwxARVJJIGthb" +
                "Gl0bGFyaW5pIHJv4oCYeXhhdGdhIG9saXNoIG1hcmthemkgKE/igJhaRFNUIDEwOTItMjAwOS1JKTEWMBQGA1UECgwNVU5JQ09OLlVaIERVSzESMBAGA1UEAwwJdW5pY29uLnV6ghABAAAAAAAAAHpoGu0rJ8ijM" +
                "GIGCCsGAQUFBwEBBFYwVDAsBggrBgEFBQcwAoYgaHR0cDovL2NhLnVuaWNvbi51ei91bmljb24tMS5jZXIwJAYIKwYBBQUHMAGGGGh0dHA6Ly9jYS51bmljb24udXovb2NzcDAPBgsqhlwDDwEBAQICAgUAA4GhA" +
                "EP37Ss6Oe9tge9JQSBL3vp1BwR2hLJk1RVq3pr+0aC2QAo7ZElR0zTK9d/1ReC4YO/b/ZLqIgBNvDGCavVSjU6JdBDUH6xFU3In5H1YPKqE5xBU7mp0cxn4tNgtehHc4NdrLzSuh+3+ZE8iBvIeu5cV1d/Bbcj5a" +
                "jKHnOP8WACVnmmVlZma4KhXULrHGKOX6nbf1rfMcB/MMVpPqtCv0F8=";
        String text = "C7E1-FFFF-6A07-21011593760580605";
        String textHash = "+6FWAiuudj4sX7uzfJ947R9MhOxA9SGJQ9a3AWvqBxg=";
        String tsignData = "NVt0SrSou9kKQ5f+IsDISE0B92PsThWm7m+afTguWSRAx3BdBqsanNYKslmb7R7UvCs/fxlYr9H1lsbcZenBj9hmJlbuS7xMH04gbYHnD08/CaD9A/J5605Ee4Y4yEjr4Mo+42Qs8gpdUh3A" +
                "WUsgPMsVWegSmf6yY3O17XSVG+MrhgPexiZtOunjf/t5bMB0T2rea4BSEarEnXTbydERmEkMLlffCwgetLPeYX326/4=";


        try {
            ISignerCli isigner = new ISignerCli("C:\\ERI\\isignercli.exe");


            String digest = isigner.digest(text);
            System.out.println("digest: " + digest);

//      imzoni tokensizlash
            String extractedSignatureAsBase64 = isigner.extractSignature(tsignData);
            System.out.println("extracted sign from base64 " + extractedSignatureAsBase64);

//      imzoni ni tekshirish
            System.out.println("verify result of extracted signature: " + isigner.verifySignature(digest, userCerAlg1B64, extractedSignatureAsBase64));

            long huserCerAlg1 = 0; //user cer handle
            if (!isigner.verifySignature(textHash, userCerAlg1B64, tsignData)) System.out.println("signature error");
//            System.out.println(isigner.checkERI(userCerAlg1B64, text, tsignData));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            e.printStackTrace(System.out);
        } finally {

        }
    }

    //  show information about library and license
    public String about() throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-about"};
        return _exec(cmd);
    }

    //  show machine uid
    public String uid() throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-uid"};
        return _exec(cmd);
    }

    //  generate machine token
    public String token() throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-token"};
        return _exec(cmd);
    }

    //  calculate hash (digest) of text (alg: UZDST 1106:2009 II)
    public String digest(String text) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-digest", text};
        return _exec(cmd);
    }

    //  calculate hash (digest) of file (alg: UZDST 1106:2009 II) v1.0.3+
    public String digestFile(String path) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-digestfile", path};
        return _exec(cmd);
    }

    //  untokenize signature
    public String extractSignature(String esignAsBase64) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-extract", esignAsBase64};
        return _exec(cmd);
    }

    //  verify signature (alg: 1092:2009 I & II)
    public boolean verifySignature(String digestAsBase64, String certAsFilePathOrBase64, String extractedSignatureAsBase64) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-verify", digestAsBase64, certAsFilePathOrBase64, extractedSignatureAsBase64};
        return Boolean.parseBoolean(_exec(cmd));
    }

    //  parse X.509 certificate
    public String parseCertificate(String certAsFilePathOrBase64) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-cerparse", certAsFilePathOrBase64};
        return _exec(cmd);
    }

    //  generate signature (alg: 1092:2009 I & II) v1.0.2+
    public String generateSignature(String digestAsBase64, String pfxAsFilePathOrBase64, String pfxPassword, String token) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-sign", digestAsBase64, pfxAsFilePathOrBase64, pfxPassword, token};
        return _exec(cmd);
    }

    //  verify tokenized signature (alg: 1092:2009 I & II) v1.0.2+
    public boolean verifyUnextractedSignature(String digestAsBase64, String certAsFilePathOrBase64, String unextractedSignatureAsBase64) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-verifytokenized", digestAsBase64, certAsFilePathOrBase64, unextractedSignatureAsBase64};
        return Boolean.parseBoolean(_exec(cmd));
    }

    //  verify certificate signature v1.0.3+
    public boolean verifyCertificateSignature(String certAsFilePathOrBase64, String rootCertAsFilePathOrBase64) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-cerverify", certAsFilePathOrBase64, rootCertAsFilePathOrBase64};
        return Boolean.parseBoolean(_exec(cmd));
    }

    //  verify crl signature v1.0.3+
    public boolean verifyCrlSignature(String crlAsFilePathOrBase64, String rootCertAsFilePathOrBase64) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-crlverify", crlAsFilePathOrBase64, rootCertAsFilePathOrBase64};
        return Boolean.parseBoolean(_exec(cmd));
    }

    //  check if certificate revoked, i.e. is in revocation list (crl) v1.0.3+
    public boolean checkIfCertificateRevoked(String certAsFilePathOrBase64, String crlAsFilePathOrBase64) throws IOException, InterruptedException {
        String[] cmd = {cliPath, "-cerisrevoked", certAsFilePathOrBase64, crlAsFilePathOrBase64};
        return Boolean.parseBoolean(_exec(cmd));
    }

    public String checkERIexe(String userCerAlg1B64, String textHash, String tsignData) throws Exception {
        String res = "";
        {
            ISignerCli isigner = new ISignerCli("C:\\ERI\\isignercli.exe");
            long huserCerAlg1 = 0; //user cer handle
            try {
                if (!isigner.verifySignature(textHash, userCerAlg1B64, tsignData)) res = "signature error";
            } catch (Exception e) {
//                System.out.println(e.getMessage());
                res = e.getMessage();
                e.printStackTrace(System.out);
            } finally {
//                isigner.cerFree(huserCerAlg1);
            }
        }
        return res;
    }
}
