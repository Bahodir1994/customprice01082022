package uz.customs.customsprice.configth;

import java.util.UUID;

public class UU_ID {
    public static void main(String args []) {
        String checkID = "";
        for (int i = 0; i < 10; i++) {
            checkID = UUID.randomUUID().toString();
            System.out.println(checkID);
        }
    }
}
