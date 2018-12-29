
public class Account {
    private int accountNumber;
    private int pin;
    private String firstName;
    private String lastName;
    private double totalBalance;

    // Account constructor to initialization
    public Account(int accountNumber, String firstName, String lastName, int pin, double totalBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.totalBalance = totalBalance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    boolean validatePIN(int userPIN) {
        // if match == (inputPIN == AccountPIN) return true, otherwise return false
        return userPIN == pin;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    int getPin() {
        return pin;
    }

    int getAccountNumber() {
        return accountNumber;
    }

    double getTotalBalance() {
        return totalBalance;
    }

    void credit(double amount) {
        totalBalance += amount;
    }

    void debit(double amount) {
        this.totalBalance -= amount;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
