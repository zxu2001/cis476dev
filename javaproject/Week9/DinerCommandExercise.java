public class DinerCommandExercise {
    // Matching exercise: Customer = Client, Order = Command,
    // orderUp() = execute, Waitress = Invoker, Cook = Receiver.
    interface Order { void orderUp(); }
    static class Cook {
        void makeBurger() { System.out.println("Make a Cheese Burger"); }
        void makeShake() { System.out.println("Make a Malt Shake"); }
    }
    static class MealOrder implements Order {
        private final Cook cook;
        MealOrder(Cook cook) { this.cook = cook; }
        public void orderUp() { cook.makeBurger(); cook.makeShake(); }
    }
    static class Waitress {
        private Order order;
        void takeOrder(Order order) { this.order = order; }
        void orderUp() { order.orderUp(); }
    }
    public static void main(String[] args) {
        Cook cook = new Cook();
        Order order = new MealOrder(cook);
        Waitress waitress = new Waitress();
        waitress.takeOrder(order);
        waitress.orderUp();
    }
}
