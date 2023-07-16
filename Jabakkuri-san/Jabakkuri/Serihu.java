package KozinKadai;

public class Serihu {
    private String red = "\u001b[00;31m";
    private String white = "\u001b[00;38m";

    public void serihu(String serihu){
        for(int i = 0; i < serihu.length(); i++) {
            System.out.print(serihu.charAt(i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public void inputSerihu(String serihu){
        for(int i = 0; i < serihu.length(); i++) {
            System.out.print(serihu.charAt(i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void jaserihu(String serihu){
        for(int i = 0; i < serihu.length(); i++) {
            System.out.println(red + "　　　" + serihu.charAt(i) + white);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    public void kaigyou(int k){
        for(int i=0;i<k;i++){
            System.out.println();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
