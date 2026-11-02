public class MallardDuckStrategyExample {
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
    static class MallardDuck extends Duck {
        MallardDuck() { flyBehavior = new FlyWithWings(); quackBehavior = new Quack(); }
        void display() { System.out.println("I'm a real Mallard duck"); }
    }
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly();
        mallard.swim();
    }
}
