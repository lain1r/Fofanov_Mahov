package org.example;

import java.sql.*;

public class Database {
    private final String host = "localhost";
    private final String port = "5432";
    private final String dbName = "Restaurant";
    private final String login = "postgres";
    private final String password = "";


    private Connection dbcon;

    private Connection getDBConnection () throws ClassNotFoundException, SQLException {
        String path = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер PostgreSQL загружен");
        } catch (ClassNotFoundException e) {
            System.out.println("Предупреждение: Драйвер PostgreSQL не найден. " +
                    "Убедитесь, что он добавлен в зависимости проекта.");
        }

        dbcon = DriverManager.getConnection(path, login , password);
        return dbcon;

    }

    public void isConnection() throws ClassNotFoundException, SQLException {
        dbcon = getDBConnection();
        System.out.println(dbcon.isValid(1000));

    }

    public void createTables() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE receipts (id SERIAL PRIMARY KEY,created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, total_amount DECIMAL(19, 2) NOT NULL  );";

        String sql2 = "CREATE TABLE receipt_items ( id SERIAL PRIMARY KEY, product_name VARCHAR(255) NOT NULL," +
                "price DECIMAL(19, 2) NOT NULL, receipt_id BIGINT, CONSTRAINT fk_receipt FOREIGN KEY (receipt_id) REFERENCES receipts (id));";
        try {
            Statement statement = getDBConnection().createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int addReceipt(double total) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO receipts (total_amount) VALUES (?)";

        try (Connection connection = getDBConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setDouble(1, total);
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating receipt failed, no ID obtained.");
                }
            }
        }
    }


    public void addReceiptItem(String productName, double price, int receipt_id) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO receipt_items (product_name, price, receipt_id) " +
                "VALUES ('" + productName + "'," + price + ","  + receipt_id +");";
        try {
            Statement statement = getDBConnection().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("ошибка в addReceiptItem "+e);
        }
    }
}