/**
 * Chain of Responsibility example 
 * Chain: ProgramManager -> DistrictManager -> COO.
 * Compile: javac PurchaseApprovalExample.java
 * Run:     java PurchaseApprovalExample
 */
public class PurchaseApprovalExample {
    public static void main(String[] args) {
        // Set up the Chain of Responsibility.
        PurchaseHandler programManager = new ProgramManager();
        PurchaseHandler districtManager = new DistrictManager();
        PurchaseHandler coo = new COO();

        programManager.setSuccessor(districtManager);
        districtManager.setSuccessor(coo);

        // Process the requests from the lecture.
        double[] requests = {42000, 55000, 114000, 920000, 1800000, 63000};
        for (double purchaseAmount : requests) {
            programManager.handleRequest(purchaseAmount);
        }
    }
}

// Handler: maintains a reference to the next handler.
abstract class PurchaseHandler {
    protected PurchaseHandler successor;

    public void setSuccessor(PurchaseHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(double purchaseAmount);
}

// Concrete handler: approves purchases below $50,000.
class ProgramManager extends PurchaseHandler {
    @Override
    public void handleRequest(double purchaseAmount) {
        if (purchaseAmount < 50000) {
            System.out.println("Request was sent to "
                + getClass().getSimpleName()
                + " to approve amount $" + purchaseAmount);
        } else if (successor != null) {
            successor.handleRequest(purchaseAmount);
        }
    }
}

// Concrete handler: approves purchases from $50,000 to below $1,000,000.
class DistrictManager extends PurchaseHandler {
    @Override
    public void handleRequest(double purchaseAmount) {
        if (purchaseAmount >= 50000 && purchaseAmount < 1000000) {
            System.out.println("Request was sent to "
                + getClass().getSimpleName()
                + " to approve amount $" + purchaseAmount);
        } else if (successor != null) {
            successor.handleRequest(purchaseAmount);
        }
    }
}

// Concrete handler: approves purchases of $1,000,000 or more.
class COO extends PurchaseHandler {
    @Override
    public void handleRequest(double purchaseAmount) {
        if (purchaseAmount >= 1000000) {
            System.out.println("Request was sent to "
                + getClass().getSimpleName()
                + " to approve amount $" + purchaseAmount);
        } else if (successor != null) {
            successor.handleRequest(purchaseAmount);
        }
    }
}
