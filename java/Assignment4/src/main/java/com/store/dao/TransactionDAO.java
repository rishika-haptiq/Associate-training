package com.store.dao;

import com.store.db.DBConnection;
import com.store.models.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public boolean recordTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (product_id, quantity, type) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, transaction.getProductId());
            stmt.setInt(2, transaction.getQuantity());
            stmt.setString(3, transaction.getType());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error recording transaction: " + e.getMessage());
            return false;
        }
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        String query = "SELECT * FROM transactions ORDER BY timestamp DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Transaction t = new Transaction(
                        rs.getInt("id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getString("type"),
                        rs.getTimestamp("timestamp")
                );
                list.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching transactions: " + e.getMessage());
        }

        return list;
    }
}
