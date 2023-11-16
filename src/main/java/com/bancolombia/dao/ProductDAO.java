package com.bancolombia.dao;

import com.bancolombia.model.Product;
import com.bancolombia.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
    // Insertar
    public static boolean insertProduct(String name, String description, double price, String category, int stock) {
        String insertQuery = "INSERT INTO product (Name, Description, Price, Category, Stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, category);
            preparedStatement.setInt(5, stock);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Actualizar
    public boolean updateProduct(Product product) {
        String updateQuery = "UPDATE product SET Name = ?, Description = ?, Price = ?, Category = ?, Stock = ? WHERE ProductID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getCategory());
            preparedStatement.setInt(5, product.getStock());
            preparedStatement.setInt(6, product.getProductID());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Borrar
    public boolean deleteProductByID(int productID) {
        String deleteQuery = "DELETE FROM product WHERE ProductID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, productID);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Obtener por id
    public static Product getProductByID(int productID) { //Cómo devolver un product como objeto sin que se cree otra vez un registro en la BD?
        String selectQuery = "SELECT * FROM product WHERE ProductID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, productID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("ProductID");

                    String name = resultSet.getString("Name");
                    String description = resultSet.getString("Description");
                    double price = resultSet.getDouble("Price");
                    String category = resultSet.getString("Category");
                    int stock = resultSet.getInt("Stock");

                    return new Product(name, description, price, category, stock);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
