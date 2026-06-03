import java.sql.*;

public class TransactionDemo {

    public static void transfer(
            int fromAcc,
            int toAcc,
            double amount
    ) {

        String url =
                "jdbc:mysql://localhost:3306/bankdb";

        try(Connection con =
                    DriverManager.getConnection(
                            url,
                            "root",
                            "root"
                    )) {

            con.setAutoCommit(false);

            PreparedStatement debit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance = balance - ? WHERE id=?"
                    );

            debit.setDouble(1, amount);
            debit.setInt(2, fromAcc);

            debit.executeUpdate();

            PreparedStatement credit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance = balance + ? WHERE id=?"
                    );

            credit.setDouble(1, amount);
            credit.setInt(2, toAcc);

            credit.executeUpdate();

            con.commit();

            System.out.println(
                    "Transfer Successful"
            );

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        transfer(1, 2, 500);
    }
}