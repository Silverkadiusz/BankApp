package BankApp.model;

public class Savings extends Account{
    private static String accountType = "Saving";

    Savings(double initialDeposit) {
        super();
        this.setBalance(initialDeposit);
        this.checkInterest();

    }

    @Override
    public String toString() {
        return "Account Type" + accountType + "Account\n" +
                "Account Number " + this.getAccountNumber() + "\n" +
                "Balance: "+ this.getBalance() +"\n" +
                "Interest Rate " + this.getInterest() +"%\n";
    }

}
