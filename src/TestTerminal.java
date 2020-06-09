import java.io.IOException;
import java.util.Random;

public class TestTerminal {
    public static void main(String[] args) {
        try {
            // kiem tra version
            System.out.print("Phien ban cua openssl dang chay trong may la:");
            execCmd("openssl version");
            // hien thi cac file trong thu muc
            System.out.println("Cac file trong thu muc project: ");
            execCmd("ls");
            //sinh key hexa random bang java
            String key = getRandomHexString(16);
            // ma hoa file anh p.jpg -> mahoa.enc
            execCmd("openssl enc -des-cbc -in p.jpg -out mahoa.enc -iv 0000000000000000 -K " + key);
            System.out.println("Da ma hoa-----------");
            // giai ma mahoa.ecn -> newP.jpg
            execCmd("openssl enc -des-cbc -d -in mahoa.enc -out newP.jpg -iv 0000000000000000 -K " + key);
            System.out.println("Da giai ma----------");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // thuc thi lenh terminal
    public static void execCmd(String cmd) throws java.io.IOException {
        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        System.out.println(s.hasNext() ? s.next() : ""); // in ket qua
    }

    private static String getRandomHexString(int numchars) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < numchars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }
}
