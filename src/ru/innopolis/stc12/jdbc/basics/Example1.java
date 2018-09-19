package ru.innopolis.stc12.jdbc.basics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class Example1 {
    public static void main(String[] args) {
        try (Connection connection = getConnection(
                "jdbc:postgresql://localhost:5432/MobilePhones",
                "postgres",
                "sa");
             ResultSet resultSet = connection.createStatement().executeQuery(
                     "SELECT * from students where city = ''");) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("name") + ";");
                System.out.print(resultSet.getString("family_name") + ";");
                System.out.print(resultSet.getInt("age") + ";");
                System.out.println(resultSet.getString("city") + ";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
