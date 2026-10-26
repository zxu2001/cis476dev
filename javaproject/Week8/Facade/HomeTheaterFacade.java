/**
 * Facade example
 * Supporting subsystem classes below are added console implementations.
 * Compile: javac HomeTheaterFacade.java
 * Run:     java HomeTheaterFacade
 */
        cd.on();
        cd.play(cdTitle);
    }

    public void endCd() {
        System.out.println("Shutting down CD...");
        amp.off();
        amp.setCd(cd);
        cd.eject();
        cd.off();
    }

    public void listenToRadio(double frequency) {
        System.out.println("Tuning in the airwaves...");
        tuner.on();
        tuner.setFrequency(frequency);
        amp.on();
        amp.setVolume(5);
        amp.setTuner(tuner);
    }

    public void endRadio() {
        System.out.println("Shutting down the tuner...");
        tuner.off();
        amp.off();
    }

    public static void main(String[] args) {
        Amplifier amp = new Amplifier("Top-O-Line Amplifier");
        Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
        DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
        CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
        Projector projector = new Projector("Top-O-Line Projector", dvd);
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                amp, tuner, dvd, cd, projector, screen, lights, popper);
        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();
    }
}

// Added subsystem implementations: each method prints the requested operation.
class Amplifier {
    private final String name;
    Amplifier(String name) { this.name = name; }
    public void on() { System.out.println(name + " on"); }
    public void off() { System.out.println(name + " off"); }
    public void setDvd(DvdPlayer dvd) { System.out.println(name + " DVD input: " + dvd); }
    public void setCd(CdPlayer cd) { System.out.println(name + " CD input: " + cd); }
    public void setTuner(Tuner tuner) { System.out.println(name + " tuner input: " + tuner); }
    public void setSurroundSound() { System.out.println(name + " surround sound"); }
    public void setStereoSound() { System.out.println(name + " stereo sound"); }
    public void setVolume(int volume) { System.out.println(name + " volume: " + volume); }
    @Override public String toString() { return name; }
}

class Tuner {
    private final String name;
    private final Amplifier amp;
    Tuner(String name, Amplifier amp) { this.name = name; this.amp = amp; }
    public void on() { System.out.println(name + " on"); }
    public void off() { System.out.println(name + " off"); }
    public void setFrequency(double frequency) {
        System.out.println(name + " frequency: " + frequency);
    }
    @Override public String toString() { return name; }
}

class DvdPlayer {
    private final String name;
    private final Amplifier amp;
    DvdPlayer(String name, Amplifier amp) { this.name = name; this.amp = amp; }
    public void on() { System.out.println(name + " on"); }
    public void off() { System.out.println(name + " off"); }
    public void play(String movie) { System.out.println(name + " playing: " + movie); }
    public void stop() { System.out.println(name + " stopped"); }
    public void eject() { System.out.println(name + " disc ejected"); }
    @Override public String toString() { return name; }
}

class CdPlayer {
    private final String name;
    private final Amplifier amp;
    CdPlayer(String name, Amplifier amp) { this.name = name; this.amp = amp; }
    public void on() { System.out.println(name + " on"); }
    public void off() { System.out.println(name + " off"); }
    public void play(String title) { System.out.println(name + " playing: " + title); }
    public void eject() { System.out.println(name + " disc ejected"); }
    @Override public String toString() { return name; }
}

class Projector {
    private final String name;
    private final DvdPlayer dvd;
    Projector(String name, DvdPlayer dvd) { this.name = name; this.dvd = dvd; }
    public void on() { System.out.println(name + " on"); }
    public void off() { System.out.println(name + " off"); }
    public void wideScreenMode() { System.out.println(name + " widescreen mode"); }
}

class TheaterLights {
    private final String name;
    TheaterLights(String name) { this.name = name; }
    public void on() { System.out.println(name + " on"); }
    public void dim(int level) { System.out.println(name + " dimmed to " + level + "%"); }
}

class Screen {
    private final String name;
    Screen(String name) { this.name = name; }
    public void down() { System.out.println(name + " down"); }
    public void up() { System.out.println(name + " up"); }
}

class PopcornPopper {
    private final String name;
    PopcornPopper(String name) { this.name = name; }
    public void on() { System.out.println(name + " on"); }
    public void off() { System.out.println(name + " off"); }
    public void pop() { System.out.println(name + " popping popcorn"); }
}
