public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(50, 50);

        System.out.println("-----------check current balance in each account-----------");
        System.out.println("Your current balance in the checking account is $" + account1.getCheckingBalance() + ".");
        System.out.println("Your current balance in the savings account is $" + account1.getSavingsBalance() + ".");
        System.out.println("-----------------------------------------------------------");

        account1.deposit(50, 10);

        account1.withdraw(80,70);
    }
}