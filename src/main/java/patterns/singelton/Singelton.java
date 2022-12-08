package patterns.singelton;

public class Singelton {
    private static volatile Singelton singelton;

    private Singelton(){
    }

    public static Singelton getInstance(){
        if (singelton == null){
            synchronized (Singelton.class){
                if (singelton == null){
                    singelton = new Singelton();
                }
            }
        }
        return singelton;
    }

}