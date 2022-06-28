import java.util.UUID;

public class UU_ID {
    public static void main(String args []) {
        String checkID = "";
        for (int i = 0; i < 1; i++) {
            checkID = UUID.randomUUID().toString();
            System.out.println(checkID);
        }
    }
}
