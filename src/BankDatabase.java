import java.sql.*;
import java.util.ArrayList;

public class BankDatabase {
    // variables for the database
    private static final String URL = "jdbc:mysql://localhost/" +
            "bankdatabase?useSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=UTC" +
            "&allowPublicKeyRetrieval=true";

    private ArrayList<Account> accounts;

    public BankDatabase() {
        accounts = new ArrayList<>();
        loadDatabase();

    }

    // retrieve account by account number
    public Account getAccount(int accountNumber) {

        for (Account currentAccount : accounts) {
            if (currentAccount.getAccountNumber() == accountNumber) {
                return currentAccount;
            }
        }
        return null;
    }

    public boolean authenticateUser(int userAccountNumber, int userPIN) {
        // retrieve account by account number
        Account userAccount = getAccount(userAccountNumber);

        // if account exist
        if (userAccount != null) {
            return userAccount.validatePIN(userPIN);
        } else {
            return false;
        }
    }


    public double getTotalBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getTotalBalance();
    }

    public void credit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).credit(amount);
    }

    public void debit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).debit(amount);
    }

    public void loadDatabase() {

        try (
                Connection connection = DriverManager.getConnection(
                        URL,
                        "Muhammed",
                        "Muhammed28"
                );
                PreparedStatement preparedStatement = connection.prepareStatement("select * from User");
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getInt("userID"),
                        resultSet.getString("userFirstName"),
                        resultSet.getString("userLastName"),
                        resultSet.getInt("userPassword"),
                        resultSet.getDouble("userTotalBalance"));

                accounts.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveDatabase(Account account) {

        try (
                Connection connection = DriverManager.getConnection(
                        URL,
                        "Muhammed",
                        "Muhammed28"
                );

                Statement statement = connection.createStatement()
        ) {

            statement.executeUpdate("update user " +
                    " set UserFirstName = " + String.format("\"%s\" ", account.getFirstName()) +
                    ", UserLastName = " + String.format("\"%s\" ", account.getLastName()) +
                    ", UserPassword = " + account.getPin() +
                    ", userTotalBalance = " + account.getTotalBalance() +
                    " where UserID = " + account.getAccountNumber()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

