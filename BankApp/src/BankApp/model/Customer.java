package BankApp.model;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String ssn;
    private final Account account;

    public Customer(String firstName, String lastName, String ssn, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", account=" + account +
                '}';
    }

    public void deposit(double amount) {
    }
}
