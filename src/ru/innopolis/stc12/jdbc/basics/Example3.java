package ru.innopolis.stc12.jdbc.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class Example3 {
    public static void main(String[] args) {
        try (Connection connection = getConnection(
                "jdbc:postgresql://localhost:5432/MobilePhones",
                "postgres",
                "sa");
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE students SET age = 20 where id = ?");
        ) {
            for (String arg : args) {
                statement.setInt(1, Integer.parseInt(arg));
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
