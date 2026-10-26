/**
 * Mortgage Facade Execise
 * Lecture class and method names are preserved, including "MorgageFacade".
 * Compile: javac MorgageFacade.java
 * Run:     java MorgageFacade
 */
public class MorgageFacade {
    private final Loan ln;
    private final Credit ct;
    private final Bank bk;
    private final Customer cr;

    public MorgageFacade(Loan ln, Credit ct, Bank bk, Customer cr) {
        this.ln = ln;
        this.ct = ct;
        this.bk = bk;
        this.cr = cr;
    }

    public boolean IsEligible(Customer cr, int loanAmount) {
        int eligibleScore = 0;
        System.out.println(cr.name + " applies for " + loanAmount);

        if (bk.HasSufficientSavings(cr, loanAmount)) {
            eligibleScore += 2;
            System.out.println("Has sufficient Saving");
        } else {
            eligibleScore -= 1;
            System.out.println("Doesn't have sufficient Saving");
        }

        if (ct.HasBadCredit(cr)) {
            eligibleScore -= 1;
            System.out.println("Has Bad Credit");
        } else {
            eligibleScore += 1;
            System.out.println("credit is good");
        }

        if (ln.HasBadLoan(cr)) {
            eligibleScore -= 1;
            System.out.println("Has bad loan");
        } else {
            eligibleScore += 1;
            System.out.println("No bad loan");
        }

        return eligibleScore >= 2;
    }

    public static void main(String[] args) {
        Customer cust = new Customer("John Bruce", 2500, false, false);
        Bank bk = new Bank();
        Loan ln = new Loan();
        Credit ct = new Credit();
        MorgageFacade mortgage = new MorgageFacade(ln, ct, bk, cust);
        boolean eligible = mortgage.IsEligible(cust, 2600);

        if (eligible) {
            System.out.println("Mortgage is approved");
        } else {
            System.out.println("Mortgage is not approved");
        }
        System.out.println();
    }
}

class Bank {
    public Bank() { }

    public boolean HasSufficientSavings(Customer customer, int amount) {
        return customer.SavingAmount > amount;
    }
}

class Credit {
    public Credit() { }

    public boolean HasBadCredit(Customer customer) {
        return customer.HasBadCredit && customer.SavingAmount < 1500;
    }
}

class Loan {
    public Loan() { }

    public boolean HasBadLoan(Customer customer) {
        return customer.CHasBadLoan() && customer.SavingAmount < 1000;
    }
}

class Customer {
    int SavingAmount;
    boolean HasBadLoan;
    boolean HasBadCredit;
    String name;

    public Customer(String name, int SavingAmount,
                    boolean HasBadCredit, boolean HasBadLoan) {
        this.name = name;
        this.SavingAmount = SavingAmount;
        this.HasBadCredit = HasBadCredit;
        this.HasBadLoan = HasBadLoan;
    }

    public String Name() {
        return name;
    }

    public boolean CHasBadCredit() {
        return HasBadCredit;
    }

    public boolean CHasBadLoan() {
        return HasBadLoan;
    }

    public int CSavingAmount() {
        return SavingAmount;
    }
}
