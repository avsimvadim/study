package patterns.command;

// Command interface
interface Command {
    void execute();
}

// Concrete commands
class TVOnCommand implements Command {
    private TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}

class TVOffCommand implements Command {
    private TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOff();
    }
}

class TVVolumeUpCommand implements Command {
    private TV tv;

    public TVVolumeUpCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.volumeUp();
    }
}

class TVVolumeDownCommand implements Command {
    private TV tv;

    public TVVolumeDownCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.volumeDown();
    }
}

// Receiver
class TV {
    public void turnOn() {
        System.out.println("TV is on");
    }

    public void turnOff() {
        System.out.println("TV is off");
    }

    public void volumeUp() {
        System.out.println("Volume up");
    }

    public void volumeDown() {
        System.out.println("Volume down");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();

        Command turnOnCommand = new TVOnCommand(tv);
        Command turnOffCommand = new TVOffCommand(tv);
        Command volumeUpCommand = new TVVolumeUpCommand(tv);
        Command volumeDownCommand = new TVVolumeDownCommand(tv);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnCommand);
        remote.pressButton();

        remote.setCommand(volumeUpCommand);
        remote.pressButton();
        remote.pressButton();

        remote.setCommand(turnOffCommand);
        remote.pressButton();
    }
}
