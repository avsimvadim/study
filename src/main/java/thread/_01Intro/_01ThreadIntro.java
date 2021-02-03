package thread._01Intro;

public class _01ThreadIntro {

    public static void main(String[] args) {
        // get current thread
        Thread main = Thread.currentThread();
        System.out.println(main.getName());
        MyThead myThead = new MyThead("poor info thread");
        //weak thread = true. die if main die
        myThead.setDaemon(true);
        myThead.start();
        for (int i = 0; i <= 25; i++) {
            System.out.printf("main working %d\n", i);
            if (i == 12) {
                myThead.interrupt();
            }
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyThead extends Thread {
    private String threadDescription;

    public MyThead(String threadDescription) {
        this.threadDescription = threadDescription;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.printf("My work %s, %s, %s\n", getId(), getName(), getState());
            try {
                sleep(1000); // interrupt
            } catch (InterruptedException e) {
                e.printStackTrace();
                interrupt();
            }
        }
    }
}
