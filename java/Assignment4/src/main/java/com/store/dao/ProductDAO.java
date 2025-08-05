package com.store.dao;

import com.store.db.DBConnection;
import com.store.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Insert new product
    public boolean insertProduct(Product product) {
        String query = "INSERT INTO products (name, category_id, quantity, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getCategoryId());
            stmt.setInt(3, product.getQuantity());
            stmt.setDouble(4, product.getPrice());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error inserting product: " + e.getMessage());
            return false;
        }
    }

    // Update existing product
    public boolean updateProduct(Product product) {
        String query = "UPDATE products SET name = ?, category_id = ?, quantity = ?, price = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getCategoryId());
            stmt.setInt(3, product.getQuantity());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error updating product: " + e.getMessage());
            return false;
        }
    }

    // Get all products with pagination
    public List<Product> getAllProducts(int limit, int offset) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products ORDER BY id LIMIT ? OFFSET ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, limit);
            stmt.setInt(2, offset);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product p = new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("category_id"),
                            rs.getInt("quantity"),
                            rs.getDouble("price")
                    );
                    products.add(p);
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching products: " + e.getMessage());
        }

        return products;
    }

    // delete product by ID
    public boolean deleteProduct(int id) {
        String query = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error deleting product: " + e.getMessage());
            return false;
        }
    }

    // fetch single product by ID (useful for update, sale, etc.)
    public Product getProductById(int id) {
        String query = "SELECT * FROM products WHERE id = ?";
        Product product = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("category_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching product by ID: " + e.getMessage());
        }

        return product;
    }
}
