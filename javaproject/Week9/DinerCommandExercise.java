import java.util.Scanner;

public class DinerCommandExercise {
    interface Order {
        void orderUp();
    }

    // Receiver for burger orders
    static class John {
        public void makeBurger() {
            System.out.println("John: Make a Cheese Burger");
        }
    }

    // Receiver for shake orders
    static class Jeff {
        public void makeShake() {
            System.out.println("Jeff: Make a Malt Shake");
        }
    }

    static class BurgerOrder implements Order {
        private final John john;

        public BurgerOrder(John john) {
            this.john = john;
        }

        @Override
        public void orderUp() {
            john.makeBurger();
        }
    }

    static class ShakeOrder implements Order {
        private final Jeff jeff;

        public ShakeOrder(Jeff jeff) {
            this.jeff = jeff;
        }

        @Override
        public void orderUp() {
            jeff.makeShake();
        }
    }

    // Invoker selects the command and receiver based on the order.
    static class Waitress {
        private final John john;
        private final Jeff jeff;
        private Order order;

        public Waitress(John john, Jeff jeff) {
            this.john = john;
            this.jeff = jeff;
        }

        public void takeOrder(int choice) {
            if (choice == 1) {
                order = new BurgerOrder(john);
            } else if (choice == 2) {
                order = new ShakeOrder(jeff);
            } else {
                throw new IllegalArgumentException("Invalid choice");
            }
        }

        public void orderUp() {
            order.orderUp();
        }
    }

    public static void main(String[] args) {
        John john = new John();
        Jeff jeff = new Jeff();
        Waitress waitress = new Waitress(john, jeff);

        Scanner input = new Scanner(System.in);
        System.out.println("1. Cheese Burger");
        System.out.println("2. Malt Shake");
        System.out.print("Choose your order: ");

        if (!input.hasNextInt()) {
            System.out.println("Please enter 1 or 2.");
            return;
        }

        int choice = input.nextInt();
        if (choice != 1 && choice != 2) {
            System.out.println("Please enter 1 or 2.");
            return;
        }

        waitress.takeOrder(choice);
        waitress.orderUp();
    }
}