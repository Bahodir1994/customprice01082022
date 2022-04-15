package uz.etranzitin.esad.Crypt;

public class Crypt {

    private int dob;
    private String key;

    public Crypt() {
        dob = 7;
        key = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./ ~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?ёйцукенгшщзхъфывапролджэячсмитьбюЁ№ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    }

    public String decrypting(String instr) {
        try {
            int i = 0, j = 0;
            int b = 0;
            int r = 0;
            int d = 0;
            String rez = "";
            String[] ar = instr.split(",");
            for (i = 0; i < ar.length; i++) {
                b = Integer.parseInt(ar[i]);
                d = b - (b / dob) * dob;
                i = i + d + 1;
                if (i < ar.length) {
                    b = Integer.parseInt(ar[i]);
                    b = b - d;
                    rez += key.charAt(b); //rez += Character.toChars(b)[0];
                }
            }
            return rez;
        } catch (Exception e) {
            System.out.println("dec - " + new java.util.Date().toString());
            e.printStackTrace(System.out);
            System.out.println(e.getMessage());
            return null;
        }
    }
}