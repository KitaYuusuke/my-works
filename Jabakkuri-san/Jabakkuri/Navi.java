package KozinKadai;
import java.util.Scanner;

public class Navi {
    Scanner input = new Scanner(System.in);
    Serihu se = new Serihu();
    private String green = "\u001b[00;32m";
    private String white = "\u001b[00;38m";

    public void start(){
        se.serihu("じゃばっくりさんを行ないます");
        se.serihu("決して遊び半分で行わず");
        se.serihu("何があってもキーボードから手を離さないでください");
        se.serihu("絶対に「誰」「食べ物」「場所」という単語を使って質問してください");
        System.out.print(green +  "はい　->　enterkey" + white);
        String any = input.nextLine();

        se.kaigyou(10);
        se.serihu("あなた：じゃばっくりさん、じゃばっくりさん、どうぞおいでください");
        se.serihu("あなた：もしおいでになられましたら「はい」と表示してください");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        se.jaserihu("はい");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
