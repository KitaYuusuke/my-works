package KozinKadai;
import java.util.Scanner;

public class QuestionInput {

    public QuestionInput() {
    }
    Scanner input = new Scanner(System.in);
    Serihu se = new Serihu();

    public Javakkuri inputq(){
        se.inputSerihu("あなた：");
        String question = input.next();
        Javakkuri ja = new Javakkuri(question);
        return ja;
    }

    public void startQ(){
        se.serihu("あなた；じゃばっくりさん、じゃばっくりさん、私の次の質問に答えてください");
    }

    public void endQ(){
        se.serihu("あなた；じゃばっくりさん、じゃばっくりさん、Javakkuriクラスまでお戻りください");
    }
}
