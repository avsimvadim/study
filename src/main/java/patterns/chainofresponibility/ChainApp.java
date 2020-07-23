package patterns.chainofresponibility;

public class ChainApp {
    public static void main(String[] args) {
        SmsLogger smsLogger = new SmsLogger(Level.ERROR);
        FileLogger fileLogger = new FileLogger(Level.DEBUG);
        smsLogger.setNext(fileLogger);

        smsLogger.writeMessage("error",Level.ERROR);
        smsLogger.writeMessage("debug",Level.DEBUG);
    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

interface Logger{
    void writeMessage(String message, int level);
}

class SmsLogger implements Logger{
    int priority;
    Logger next;

    public SmsLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next){
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if(level <= priority){
            System.out.println(message + " into sms");
        }
        if (next != null){
            next.writeMessage(message, level);
        }
    }
}

class FileLogger implements Logger{
    int priority;
    Logger next;

    public FileLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next){
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if(level <= priority){
            System.out.println(message + " into file");
        }
        if (next != null){
            next.writeMessage(message, level);
        }
    }
}