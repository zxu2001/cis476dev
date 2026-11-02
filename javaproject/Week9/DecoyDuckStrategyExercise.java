public class DecoyDuckStrategyExercise {
    interface FlyBehavior { void fly(); }
    interface QuackBehavior { void quack(); }
    static class FlyWithWings implements FlyBehavior {
        public void fly() { System.out.println("I'm flying!!"); }
    }
    static class FlyNoWay implements FlyBehavior {
        public void fly() { System.out.println("I can't fly"); }
    }
    static class Quack implements QuackBehavior {
        public void quack() { System.out.println("Quack"); }
    }
    static class Squeak implements QuackBehavior {
        public void quack() { System.out.println("Squeak"); }
    }
    abstract static class Duck {
        protected FlyBehavior flyBehavior;
        protected QuackBehavior quackBehavior;
        abstract void display();
        void performFly() { flyBehavior.fly(); }
        void performQuack() { quackBehavior.quack(); }
        void swim() { System.out.println("All ducks float, even decoys!"); }
    }
    static class FakeQuack implements QuackBehavior {
        public void quack() { System.out.println("Fake Quack"); }
    }
    static class FlyRocketPowered implements FlyBehavior {
        public void fly() { System.out.println("I'm flying with a rocket"); }
    }
    static class DecoyDuck extends Duck {
        DecoyDuck() { quackBehavior = new FakeQuack(); flyBehavior = new FlyRocketPowered(); }
        void display() { System.out.println("I'm a duck Decoy"); }
    }
    public static void main(String[] args) {
        Duck decoy = new DecoyDuck();
        decoy.display();
        decoy.performQuack();
        decoy.performFly();
    }
}