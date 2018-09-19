package ru.innopolis.stc12.jdbc.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class Example2 {
    public static void main(String[] args) {
        try (Connection connection = getConnection(
                "jdbc:postgresql://localhost:5432/MobilePhones",
                "postgres",
                "sa");
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * from students where city=? and age > ?");
        ) {

            statement.setString(1, "Moskva");
            statement.setInt(2, 18);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("name") + ";");
                    System.out.print(resultSet.getString("family_name") + ";");
                    System.out.print(resultSet.getInt("age") + ";");
                    System.out.println(resultSet.getString("city") + ";");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
