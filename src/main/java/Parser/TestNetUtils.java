package Parser;

public class TestNetUtils {
    public static void main(String[] args) {
        try {
            NetUtils.load("http://dl.mp3party.net/download/8703228",
                    "C:\\Users\\avsim\\IdeaProjects\\study\\src\\main\\resources\\audio.mp3");
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
