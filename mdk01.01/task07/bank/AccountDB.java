package org.example.bank;

import java.sql.*;

public class AccountDB {
    private Connection connection;

    public AccountDB(Connection connection) {
        this.connection = connection;
    }

    public void transferMoney(String fromCard, String toCard, double amount) throws SQLException {
        String withdrawSql = "UPDATE accounts SET balance = balance - ? WHERE card_number = ?";
        String depositSql = "UPDATE accounts SET balance = balance + ? WHERE card_number = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement psWithdraw = connection.prepareStatement(withdrawSql)) {
                psWithdraw.setDouble(1, amount);
                psWithdraw.setString(2, fromCard);
                int updated = psWithdraw.executeUpdate();
                if (updated == 0) throw new SQLException("Счет отправителя не найден");
            }

            try (PreparedStatement psDeposit = connection.prepareStatement(depositSql)) {
                psDeposit.setDouble(1, amount);
                psDeposit.setString(2, toCard);
                psDeposit.executeUpdate();
            }

            connection.commit();
            System.out.println("Транзакция завершена успешно.");

        } catch (SQLException e) {
            connection.rollback();
            System.err.println("Ошибка транзакции, изменения отменены: " + e.getMessage());
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public void updateBalance(String cardNum, double newBalance) throws SQLException {
        String sql = "UPDATE accounts SET balance = ? WHERE card_number = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, newBalance);
            ps.setString(2, cardNum);
            ps.executeUpdate();
        }
    }
}