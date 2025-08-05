package com.store.dao;

import com.store.db.DBConnection;
import com.store.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        String query = "SELECT * FROM categories ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                categories.add(category);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching categories: " + e.getMessage());
        }

        return categories;
    }
}
