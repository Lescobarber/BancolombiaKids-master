package com.bancolombia.dao;

import com.bancolombia.model.UserKid;
import com.bancolombia.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UserKidDAO {

    // Insertar (Registrar)
    public static boolean insertUserKid(UserKid userKid) {
        String insertQuery = "INSERT INTO userkid (Username, Password, Name, Age, Hobbies, LoginData) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, userKid.getUsername());
            preparedStatement.setString(2, userKid.getPassword());
            preparedStatement.setString(3, userKid.getName());
            preparedStatement.setInt(4, userKid.getAge());
            preparedStatement.setString(5, userKid.getHobbies());
            preparedStatement.setString(6, userKid.getLoginData());

            int rowsAffected = preparedStatement.executeUpdate();
            userKid.setUserKidID(getLastId());
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    private static int getLastId(){
        String selectQuery = "SELECT UserKidID FROM userkid ORDER BY UserKidId DESC LIMIT 1";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("UserKidID");
                    return id;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return 0;
    }


    //Actualizar
    public static boolean updateUserKid(UserKid userKid) {
        String updateQuery = "UPDATE userkid SET Name = ?, Age = ?, Hobbies = ?, LoginData = ? WHERE UserKidID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, userKid.getName());
            preparedStatement.setInt(2, userKid.getAge());
            preparedStatement.setString(3, userKid.getHobbies());
            preparedStatement.setString(4, userKid.getLoginData());
            preparedStatement.setInt(5, userKid.getUserKidID());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Borrar
    public boolean deleteUserKidByID(int userKidID) {
        String deleteQuery = "DELETE FROM userkid WHERE UserKidID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, userKidID);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Obtener por ID: Como devolver un userKid cómo objeto sin que se cree otra vez un registro en la BD?
    public String getUserKidByID(int userKidID) {
        String selectQuery = "SELECT * FROM UserKid WHERE UserKidID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, userKidID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    int id = resultSet.getInt("UserKidID");
                    String name = resultSet.getString("Name");
                    int age = resultSet.getInt("Age");


                    String strHobbies = resultSet.getString("Hobbies");
                    List<String> listHobbies = Arrays.asList(strHobbies.split(", "));

                    String loginData = resultSet.getString("LoginData");

                    String strUser = name.toUpperCase() + "\n" + age + " años" + "\nIntereses: " + strHobbies;
                    return strUser;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Autenticar o LogIn
    public static UserKid authenticateUserKid(String username, String password) {
        String selectQuery = "SELECT * FROM userkid WHERE Username = ? AND Password = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // User authentication successful
                    return mapResultSetToUserKid(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    // Helper method to map the ResultSet to a UserKid object
    private static UserKid mapResultSetToUserKid(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("UserName");
        String password = resultSet.getString("Password");
        String name = resultSet.getString("Name");
        int age = resultSet.getInt("Age");

        return new UserKid(username, password, name, age);
    }
}
