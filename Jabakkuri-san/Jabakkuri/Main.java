package KozinKadai;

public class Main {
    public static void main(String[] args) {
        Opening opening = new Opening();
        opening.op();

        Navi navi = new Navi();
        navi.start();

        Questions q = new Questions();
        q.question();
    }
}
