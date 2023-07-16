package KozinKadai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Opening {
    private List<String> hiragana = new ArrayList<String>(Arrays.asList("あ","が","さ","た","な","ば","ま","や","ら","わ",
            "い","き","し","ぢ","に","ぴ","み","ぃ","り","う","く","す","つ","ぬ","ぶ","む","ゆ","る","ゅ","を","え","け","せ",
            "て","ね","べ","め","ぇ","れ","お","こ","そ","と","の","ぼ","も","よ","ょ","ろ","ん"));
    private List<String> randh = new ArrayList<String>();
    private String onest;
    private List<String> titles = new ArrayList<String>(Arrays.asList("じ","ゃ","ば","っ","く","り","呪","　"));
    private int count = 0;
    private int maxCount = 25;
    private String red = "\u001b[00;31m";
    private String white = "\u001b[00;38m";

    public Opening(){

    }

    public void inputRandh(){
        Collections.shuffle(hiragana);
        randh.clear();
        for(int i=0;i<3;i++){
            randh.add(hiragana.get(i));
        }
    }

    public void inputOnest(int i,int count){
        if(i==0 && count>=5){
            onest = titles.get(0);
            System.out.print(red + onest);
        }
        else if(i==1 && count>=7 ) {
            onest = titles.get(1);
            System.out.print(red + onest);
        }
        else if(i==2 && count>=9){
            onest = titles.get(2);
            System.out.print(red + onest);
        }
        else if(i==3 && count>=11){
            onest = titles.get(3);
            System.out.print(red + onest);
        }
        else if(i==4 && count>=13){
            onest = titles.get(4);
            System.out.print(red + onest);
        }
        else if(i==5 && count>=15){
            onest = titles.get(5);
            System.out.print(red + onest);
        }
        else{
            onest = hiragana.get(7);
            System.out.print(onest);
        }
    }

    public void countCurse(){

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        randh.clear();
        for(int i=0;i<3;i++){
            randh.add(titles.get(6));
        }

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
        for(int i=0;i<6;i++){
            for(String h:randh){
                System.out.print(white + h);
            }
            inputOnest(i,count);

            for(String h:randh){
                System.out.print(white + h);
            }
            System.out.println();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeCurse(int count){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
        for(int i=5;i>=0;i--){
            for(String h:randh){
                if(count+i >= 24){
                    System.out.print(white + h.replace("呪","　"));
                }
                else {
                    System.out.print(white + h);
                }
            }
            inputOnest(5-i,count);

            for(String h:randh){
                if(count+i >= 24){
                    System.out.print(white + h.replace("呪","　"));
                }
                else {
                    System.out.print(white + h);
                }
            }
            System.out.println();
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void op(){
        while(true){
            if(count == maxCount){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                break;
            }
            else if(count == 18){
                countCurse();
                count++;
                continue;
            }
            else if(count>=19){
                removeCurse(count);
                count++;
                continue;
            }
            else {
                count++;
            }

            System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
            for(int i=0;i<6;i++){
                inputRandh();
                for(String h:randh){
                    System.out.print(white + h);
                }
                inputOnest(i,count);

                inputRandh();
                for(String h:randh){
                    System.out.print(white + h);
                }
                System.out.println();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }




}
