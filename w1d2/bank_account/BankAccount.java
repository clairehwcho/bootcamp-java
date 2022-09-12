public class BankAccount {
    // MEMBER VARIABLES
    // The class should have the following attributes: (double) checking balance, (double) savings balance.
    private double checkingBalance;
    private double savingsBalance;

    // Create a class member (static) that has the number of accounts created thus far.
    private static int numberOfAccounts = 0;

    // Create a class member (static) that tracks the total amount of money stored in every account created.
    private static double totalAmountOfMoney = 0;

    // CONSTRUCTOR
    // In the constructor, be sure to increment the account count.
    public BankAccount(double amount1, double amount2){
        this.checkingBalance += amount1;
        this.savingsBalance += amount2;
        numberOfAccounts++;
        totalAmountOfMoney = this.checkingBalance + this.savingsBalance;
    }

    // GETTERS
    // Create a getter method for the user's checking account balance.
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    // Create a getter method for the user's saving account balance.
    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    // Create a method that will allow a user to deposit money into either the checking or saving.
    // Be sure to add to total amount stored.
    public void deposit(double amount1, double amount2){
        this.checkingBalance += amount1;
        this.savingsBalance += amount2;
        this.totalAmountOfMoney = totalAmountOfMoney + amount1 + amount2;
        if (amount1 > 0){
            System.out.println("You have deposited $" + amount1 + " into the checking account.");
        }
        if (amount2 >0){
            System.out.println("You have deposited $" + amount2 + " into the savings account.");
        }
        System.out.println("The total amount stored in your accounts is $" + this.totalAmountOfMoney);
        System.out.println("-----------------------------------------------------------");
    }

    // Create a method to withdraw money from one balance.
    // Do not allow them to withdraw money if there are insufficient funds.
    public void withdraw(double amount1, double amount2){
        if (amount1 > this.checkingBalance){
            System.out.println("There are insufficient funds in your checking account.");
        }
        else {
            this.checkingBalance -= amount1;
            this.totalAmountOfMoney = totalAmountOfMoney - amount1;
            System.out.println("You have withdrawn $" + amount1 + " from the checking account.");
        }
        if (amount2 > this.savingsBalance){
            System.out.println("There are insufficient funds in your savings account.");
        }
        else {
            this.savingsBalance -= amount2;
            this.totalAmountOfMoney = totalAmountOfMoney - amount2;
            System.out.println("The total amount stored in your accounts is $" + this.totalAmountOfMoney);
        }
        System.out.println("The total amount stored in your accounts is $" + this.totalAmountOfMoney);
        System.out.println("-----------------------------------------------------------");
        }

    // Users should not be able to set any of the attributes from the class.

    // NINJA BONUS: Add the the following class attribute: account number. The type is up to you, can be a String or a Long or another type.

    // NINJA BONUS: Create a private method that returns a random ten digit account number.

    // NINJA BONUS: In the constructor, call the private method from above so that each user has a random ten digit account.
    }
