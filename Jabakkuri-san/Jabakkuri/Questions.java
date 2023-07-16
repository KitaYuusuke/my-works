package KozinKadai;
import java.util.Scanner;

public class Questions {
    private String green = "\u001b[00;32m";
    private String white = "\u001b[00;38m";
    Serihu se = new Serihu();

    public void question(){
        while(true) {
            QuestionInput qi = new QuestionInput();
            qi.startQ();
            Javakkuri ja = qi.inputq();
            System.out.println();
            ja.answer();
            qi.endQ();
            String ans = select();
            if(ans.equals("はい")){

            }
            else if(ans.equals("いいえ")){
                se.serihu("あなた：じゃばっくりさん、じゃばっくりさん、ありがとうございました");
                break;
            }
            else{
                se.serihu("あなた：（答えが伝わらなかったようだ...）");
                se.serihu("あなた：（恐ろしいしここらへんでやめておこう）");
                se.serihu("あなた：じゃばっくりさん、じゃばっくりさん、ありがとうございました");
                break;
            }
        }
    }

    public String select(){
        Scanner input = new Scanner(System.in);
        se.serihu(green + "質問を続けますか？");
        se.serihu("はい　  いいえ");
        System.out.print(white);
        se.inputSerihu("あなた：");
        String ans = input.next();

        return ans;
    }

}
