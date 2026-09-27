public class WidgetDemo {
    public static void main(String[] args) {
        AbstractFactoryWidget windowsFactory = new ConcreteWindow();
        new Client(windowsFactory).run();

        AbstractFactoryWidget macFactory = new ConcreteMac();
        new Client(macFactory).run();
    }
}

// Abstract factory
abstract class AbstractFactoryWidget {
    public abstract AbstractTextField createTextField();
    public abstract AbstractPushButton createPushButton();
}

// Concrete factories
class ConcreteWindow extends AbstractFactoryWidget {
    @Override
    public AbstractTextField createTextField() {
        return new TextFieldWindow();
    }

    @Override
    public AbstractPushButton createPushButton() {
        return new PushButtonWindow();
    }
}

class ConcreteMac extends AbstractFactoryWidget {
    @Override
    public AbstractTextField createTextField() {
        return new TextFieldMac();
    }

    @Override
    public AbstractPushButton createPushButton() {
        return new PushButtonMac();
    }
}

// Abstract products
abstract class AbstractTextField {
    public abstract void displayName();
}

abstract class AbstractPushButton {
    public abstract void displayName();
}

// Windows products
class TextFieldWindow extends AbstractTextField {
    @Override
    public void displayName() {
        System.out.println(
            "This is Window TextField as " + getClass().getSimpleName()
        );
    }
}

class PushButtonWindow extends AbstractPushButton {
    @Override
    public void displayName() {
        System.out.println(
            "This is Window Button as " + getClass().getSimpleName()
        );
    }
}

// Mac products
class TextFieldMac extends AbstractTextField {
    @Override
    public void displayName() {
        System.out.println(
            "This is Mac TextField as " + getClass().getSimpleName()
        );
    }
}

class PushButtonMac extends AbstractPushButton {
    @Override
    public void displayName() {
        System.out.println(
            "This is Mac Button as " + getClass().getSimpleName()
        );
    }
}

// Client uses only the abstract factory and abstract products.
class Client {
    private final AbstractTextField textField;
    private final AbstractPushButton pushButton;

    public Client(AbstractFactoryWidget factory) {
        pushButton = factory.createPushButton();
        textField = factory.createTextField();
    }

    public void run() {
        pushButton.displayName();
        textField.displayName();
    }
}