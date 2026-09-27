public class VehicleDemo {
    public static void main(String[] args) {
        Shop shop = new Shop();

        VehicleBuilder[] builders = {
            new MiniVan(), new SportsCar(), new Motorcycle()
        };
        String[] names = { "MiniVan", "SportsCar", "Motorcycle" };

        for (int i = 0; i < builders.length; i++) {
            shop.construct(builders[i]);
            System.out.println(names[i] + " -------");
            builders[i].getResult().show();
            System.out.println();
        }
    }
}

// Director: follows the same construction steps for every vehicle.
class Shop {
    public void construct(VehicleBuilder builder) {
        builder.buildDoors();
        builder.buildSeats();
        builder.buildWheels();
    }
}

// Abstract builder: defines the construction steps.
abstract class VehicleBuilder {
    public abstract void buildDoors();
    public abstract void buildSeats();
    public abstract void buildWheels();
    public abstract Vehicle getResult();
}

// Product: stores the completed vehicle's parts.
class Vehicle {
    private String doors;
    private String seats;
    private String wheels;

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public void show() {
        System.out.println("Doors: " + doors);
        System.out.println("Seats: " + seats);
        System.out.println("Wheels: " + wheels);
    }
}

// Concrete builder: MiniVan.
class MiniVan extends VehicleBuilder {
    private final Vehicle vehicle = new Vehicle();

    @Override
    public void buildDoors() {
        vehicle.setDoors("4 doors");
    }

    @Override
    public void buildSeats() {
        vehicle.setSeats("7 seats");
    }

    @Override
    public void buildWheels() {
        vehicle.setWheels("4 wheels");
    }

    @Override
    public Vehicle getResult() {
        return vehicle;
    }
}

// Concrete builder: SportsCar.
class SportsCar extends VehicleBuilder {
    private final Vehicle vehicle = new Vehicle();

    @Override
    public void buildDoors() {
        vehicle.setDoors("2 doors");
    }

    @Override
    public void buildSeats() {
        vehicle.setSeats("4 seats");
    }

    @Override
    public void buildWheels() {
        vehicle.setWheels("4 wheels");
    }

    @Override
    public Vehicle getResult() {
        return vehicle;
    }
}

// Concrete builder: Motorcycle.
class Motorcycle extends VehicleBuilder {
    private final Vehicle vehicle = new Vehicle();

    @Override
    public void buildDoors() {
        vehicle.setDoors("0 doors");
    }

    @Override
    public void buildSeats() {
        vehicle.setSeats("2 seats");
    }

    @Override
    public void buildWheels() {
        vehicle.setWheels("2 wheels");
    }

    @Override
    public Vehicle getResult() {
        return vehicle;
    }
}