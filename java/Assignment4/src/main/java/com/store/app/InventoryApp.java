package com.store.app;

import com.store.dao.CategoryDAO;
import com.store.dao.ProductDAO;
import com.store.models.Category;
import com.store.models.Product;

import java.util.List;
import java.util.Scanner;

public class InventoryApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoryDAO categoryDAO = new CategoryDAO();
        ProductDAO productDAO = new ProductDAO();

        while (true) {
            System.out.println("\n----- Buy_Here Inventory -----");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. View Transaction History");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    // Add Product
                    List<Category> categories = categoryDAO.getAllCategories();
                    System.out.println("\nAvailable Categories:");
                    for (Category c : categories) {
                        System.out.println(c);
                    }

                    System.out.print("Enter category ID: ");
                    int categoryId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Product newProduct = new Product(0, name, categoryId, quantity, price);
                    boolean success = productDAO.insertProduct(newProduct);

                    System.out.println(success ? " Product added successfully!" : "Failed to add product.");
                    break;

                case "2":
                    // View Products with Pagination
                    System.out.print("How many products per page? ");
                    int limit = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter page number (starting from 1): ");
                    int page = Integer.parseInt(scanner.nextLine());
                    int offset = (page - 1) * limit;

                    List<Product> products = productDAO.getAllProducts(limit, offset);
                    if (products.isEmpty()) {
                        System.out.println("No products found.");
                    } else {
                        System.out.println("\nAvailable Products:");
                        for (Product p : products) {
                            System.out.println(p);
                        }
                    }
                    break;

                case "3":
                    // Update Product
                    List<Product> updateList = productDAO.getAllProducts(50, 0);
                    System.out.println("\nAvailable Products:");
                    for (Product p : updateList) {
                        System.out.println(p);
                    }

                    System.out.print("Enter product ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());

                    Product existing = productDAO.getProductById(updateId);
                    if (existing == null) {
                        System.out.println("Product not found.");
                        break;
                    }

                    System.out.print("New name [" + existing.getName() + "]: ");
                    String newName = scanner.nextLine();
                    if (newName.isEmpty()) newName = existing.getName();

                    System.out.print("New quantity [" + existing.getQuantity() + "]: ");
                    String qtyInput = scanner.nextLine();
                    int newQty = qtyInput.isEmpty() ? existing.getQuantity() : Integer.parseInt(qtyInput);

                    System.out.print("New price [" + existing.getPrice() + "]: ");
                    String priceInput = scanner.nextLine();
                    double newPrice = priceInput.isEmpty() ? existing.getPrice() : Double.parseDouble(priceInput);

                    List<Category> categoryList = categoryDAO.getAllCategories();
                    for (Category c : categoryList) {
                        System.out.println(c);
                    }
                    System.out.print("New category ID [" + existing.getCategoryId() + "]: ");
                    String catInput = scanner.nextLine();
                    int newCatId = catInput.isEmpty() ? existing.getCategoryId() : Integer.parseInt(catInput);

                    Product updated = new Product(updateId, newName, newCatId, newQty, newPrice);
                    boolean updatedSuccess = productDAO.updateProduct(updated);
                    System.out.println(updatedSuccess ? "Product updated." : "Failed to update.");
                    break;

                case "4":
                    // Delete Product
                    List<Product> deleteList = productDAO.getAllProducts(50, 0);
                    System.out.println("\nAvailable Products:");
                    for (Product p : deleteList) {
                        System.out.println(p);
                    }

                    System.out.print("Enter product ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());

                    Product target = productDAO.getProductById(deleteId);
                    if (target == null) {
                        System.out.println("Product not found.");
                        break;
                    }

                    System.out.print("Are you sure you want to delete '" + target.getName() + "'? (y/n): ");
                    String confirm = scanner.nextLine().trim().toLowerCase();

                    if (confirm.equals("y")) {
                        boolean deleted = productDAO.deleteProduct(deleteId);
                        System.out.println(deleted ? "Product deleted." : " Could not delete.");
                    } else {
                        System.out.println("Cancelled.");
                    }
                    break;

                case "5":
                    System.out.println(" Transaction feature coming soon...");
                    break;

                case "0":
                    System.out.println("Exiting. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
