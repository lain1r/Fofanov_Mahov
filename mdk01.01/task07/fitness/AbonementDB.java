package org.example.fitness;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbonementDB {
    private Connection connection;

    public AbonementDB(Connection connection) {
        this.connection = connection;
    }
    public void save(Abonement a) throws SQLException {
        String sql = "INSERT INTO abonements (first_name, last_name, type, end_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, a.getOwner().firstName);
            ps.setString(2, a.getOwner().lastName);
            ps.setString(3, a.getClass().getSimpleName());
            ps.setDate(4, Date.valueOf(a.endDate));
            ps.executeUpdate();
        }
    }

    public List<String> findByLastName(String lastName) throws SQLException {
        List<String> results = new ArrayList<>();
        String sql = "SELECT * FROM abonements WHERE last_name = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, lastName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.add(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        }
        return results;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM abonements WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}