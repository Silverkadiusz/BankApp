package BankApp.model;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    Bank bank = new Bank();

    boolean exit;

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.runMenu();

    }

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("|                     |");
        System.out.println("|   AppBank vol 1.0   |");
        System.out.println("|                     |");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
    }


    private void printMenu() {
        System.out.println("Please make a selection:");
        System.out.println("1 - Create a new Account");
        System.out.println("2 - Make a deposit");
        System.out.println("3 - Make a withdrawal");
        System.out.println("4 - List account balance");
        System.out.println("0 - Exit");
    }

    private int getInput() {
        int choice = -1;
        do {
            System.out.println("Enter your choice");
            try {
                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid option! Enter correct option...");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Choice outside of rande. Please chose again.");

            }
        } while (choice < 0 || choice > 4);
        return choice;
    }


    private void performAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank you bye");
                System.exit(0);
                break;
            case 1:
                createAnAccount();
                break;
            case 2:
                makeADeposit();
                break;
            case 3:
                makeAWithdrawal();
                break;
            case 4:
                listBalances();
                break;
            default:
                System.out.println("Unknow error has occured");
        }
    }


    private void createAnAccount() {
        String firstName, lastName, ssn, accountType = " ";
        double initialDeposit = 0;

        boolean valid = false;

        while (!valid) {
            System.out.println("Please enter an account type: checking/saving");
            accountType = sc.nextLine();
            if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("saving")) {
                valid = true;
            } else {
                System.out.println("Invalid account type selected. Please enter checking or saving.");
            }
        }

        System.out.println("Please enter your first name: ");
        firstName = sc.nextLine();
        System.out.println("Please enter your last name: ");
        lastName = sc.nextLine();
        System.out.println("Please enter your social security number:");
        ssn = sc.nextLine();
        valid = false;
        while (!valid) {
            System.out.println("Please enter an initial deposit: ");
            try {
                initialDeposit = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Deposit must be a number");
            }

            if (accountType.equalsIgnoreCase("checking")) {
                if (initialDeposit < 100) {
                    System.out.println("Checking accounts require a minimum of $100 to open.");
                } else {
                    valid = true;
                }

            } else if (accountType.equalsIgnoreCase("saving")) {
                if (initialDeposit < 50) {
                    System.out.println("Checking accounts require a minimum of $50 to open.");
                } else {
                    valid = true;
                }

            }

        }
        Account account;
        if (accountType.equalsIgnoreCase("checking")) {
            account = new Checking(initialDeposit);
        } else {
            account = new Savings(initialDeposit);
        }

        Customer customer = new Customer(firstName, lastName, ssn, account);
        bank.addCustomer(customer);


    }


    private void makeADeposit() {
        int account = selectAccount();
        System.out.println("How much would u like to deposit?: ");

        double amount = 0;
        try{
            amount = Double.parseDouble(sc.nextLine());

        }
        catch (NumberFormatException e ){
            amount = 0;
        }
        bank.getCustomer(account).deposit(amount);
    }

    private int selectAccount() {
        return 0;
    }


    private void makeAWithdrawal() {

    }


    private void listBalances() {

    }







}




