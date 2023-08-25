package patterns.facade;

// Subsystem components
class DVDPlayer {
    public void on() {
        System.out.println("DVD player is ON");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void off() {
        System.out.println("DVD player is OFF");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }

    public void setInput(DVDPlayer dvdPlayer) {
        System.out.println("Projector is set to DVD player input");
    }

    public void off() {
        System.out.println("Projector is OFF");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound system is ON");
    }

    public void setVolume(int volume) {
        System.out.println("Volume set to " + volume);
    }

    public void off() {
        System.out.println("Sound system is OFF");
    }
}

// Facade class
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        dvdPlayer.on();
        projector.on();
        projector.setInput(dvdPlayer);
        soundSystem.on();
        soundSystem.setVolume(8);
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        dvdPlayer.off();
        projector.off();
        soundSystem.off();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create subsystem components
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();

        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem);

        // Watch a movie using the facade
        homeTheater.watchMovie("Inception");

        // End the movie using the facade
        homeTheater.endMovie();
    }
}
