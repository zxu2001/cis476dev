public class AerospaceExample {
    public static void main(String[] args) {
        AerospaceEngineer engineer = new AerospaceEngineer();

        AirplaneBuilder[] builders = {
            new CropDuster(),
            new FighterJet(),
            new Glider()
        };

        for (AirplaneBuilder builder : builders) {
            Airplane airplane = engineer.construct(builder);
            System.out.println(airplane);
            System.out.println();
        }
    }
}

class Airplane {
    private final String model;
    private String wingspan;
    private String engine;
    private int crewSeats;
    private int passengerSeats;

    Airplane(String model) {
        this.model = model;
    }

    void setWingspan(String wingspan) {
        this.wingspan = wingspan;
    }

    void setEngine(String engine) {
        this.engine = engine;
    }

    void setCrewSeats(int crewSeats) {
        this.crewSeats = crewSeats;
    }

    void setPassengerSeats(int passengerSeats) {
        this.passengerSeats = passengerSeats;
    }

    @Override
    public String toString() {
        return model + "\n"
            + "Wingspan: " + wingspan + "\n"
            + "Engine: " + engine + "\n"
            + "Crew seats: " + crewSeats + "\n"
            + "Passenger seats: " + passengerSeats;
    }
}

abstract class AirplaneBuilder {
    protected Airplane airplane;

    public abstract void buildWingspan();
    public abstract void buildEngine();
    public abstract void buildSeats();

    public Airplane getResult() {
        return airplane;
    }
}

class CropDuster extends AirplaneBuilder {
    CropDuster() {
        airplane = new Airplane("Crop Duster");
    }

    public void buildWingspan() {
        airplane.setWingspan("9 ft");
    }

    public void buildEngine() {
        airplane.setEngine("Single piston");
    }

    public void buildSeats() {
        airplane.setCrewSeats(1);
        airplane.setPassengerSeats(1);
    }
}

class FighterJet extends AirplaneBuilder {
    FighterJet() {
        airplane = new Airplane("Fighter Jet");
    }

    public void buildWingspan() {
        airplane.setWingspan("35 ft");
    }

    public void buildEngine() {
        airplane.setEngine("Dual thrust vectoring");
    }

    public void buildSeats() {
        airplane.setCrewSeats(1);
        airplane.setPassengerSeats(0);
    }
}

class Glider extends AirplaneBuilder {
    Glider() {
        airplane = new Airplane("Glider");
    }

    public void buildWingspan() {
        airplane.setWingspan("57.1 ft");
    }

    public void buildEngine() {
        airplane.setEngine("N/A");
    }

    public void buildSeats() {
        airplane.setCrewSeats(1);
        airplane.setPassengerSeats(0);
    }
}

class AerospaceEngineer {
    public Airplane construct(AirplaneBuilder builder) {
        builder.buildWingspan();
        builder.buildEngine();
        builder.buildSeats();
        return builder.getResult();
    }
}
// Run it with `javac AerospaceExample.java` followed by `java AerospaceExample`.