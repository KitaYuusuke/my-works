package KozinKadai;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Javakkuri {
    Scanner input = new Scanner(System.in);
    Serihu se = new Serihu();
    private String question;
    private List<String> splita;
    private List<String> human = new ArrayList<String>(Arrays.asList("たかし","かずお","ぼぶ","まいける","あなた"));
    private List<String> food = new ArrayList<String>(Arrays.asList("とうふ","おはぎ","ほたて","やきとり","せろり"));
    private List<String> place = new ArrayList<String>(Arrays.asList("でぃずにーらんど","い｜すた｜とう","かぎだい","まちゅぴちゅ","とっとり"));
    private int listSize = human.size();

    public Javakkuri(String question) {
                this.question = question;
    }

    public void answer(){
        Random rand = new Random();
        int index = rand.nextInt(this.listSize);
        if(question.contains("誰")){
            se.jaserihu(human.get(index));
        }
        else if(question.contains("食べ物")){
            se.jaserihu(food.get(index));
        }
        else if(question.contains("場所")){
            se.jaserihu(place.get(index));
        }
        else{
            se.serihu("... (あなた；質問の仕方が悪かったようだ... いったん戻ってもらおう)");
        }
    }

    public String getQuestion() {
        return question;
    }
}
