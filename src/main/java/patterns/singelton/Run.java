package patterns.singelton;

public class Run {
    public static void main(String[] args) {
        Singelton singelton = Singelton.getInstance();
        Singelton singelton2 = Singelton.getInstance();
        System.out.println(singelton.equals(singelton2));
        System.out.println(singelton == singelton2);
    }
}
