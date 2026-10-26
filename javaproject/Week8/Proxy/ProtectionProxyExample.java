import java.util.Scanner;

/**
 * Protection Proxy Exercise.
 * Demo password: thePassword
 * Compile: javac ProtectionProxyExample.java
 * Run:     java ProtectionProxyExample
 */
public class ProtectionProxyExample {
    public static void main(String[] args) {
        IClient client = new ProtectionProxy("thePassword");
        System.out.println();
        System.out.println("main received: " + client.getAccountNo());
    }
}

// Subject: the interface shared by the real client and its proxy.
interface IClient {
    String getAccountNo();
}

// Real subject: stores and returns the account number.
class RealClient implements IClient {
    private final String accountNo = "12345";

    public RealClient() {
        System.out.println("RealClient: Initialized");
    }

    @Override
    public String getAccountNo() {
        System.out.println("RealClient's AccountNo: " + accountNo);
        return accountNo;
    }
}

// Protection proxy: authenticates the user before delegating access.
class ProtectionProxy implements IClient {
    private final String password;
    private final RealClient client;
    private final Scanner input;

    public ProtectionProxy(String password) {
        System.out.println("ProtectionProxy: Initialized");
        this.password = password;
        this.client = new RealClient();
        this.input = new Scanner(System.in);
    }

    @Override
    public String getAccountNo() {
        System.out.print("Password: ");
        String enteredPassword = input.hasNextLine() ? input.nextLine() : "";

        // Java compares string contents with equals(), rather than ==.
        if (password.equals(enteredPassword)) {
            return client.getAccountNo();
        }

        System.out.println("Illegal password!");
        return "";
    }
}
