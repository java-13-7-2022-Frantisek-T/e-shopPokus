package com.company;

import java.math.BigDecimal;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try (
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/e-shop",
                        "root",
                        "ift_610228*2022X"))
        {
            Statement statement = con.createStatement();
            statement.executeQuery(
                    "SELECT * FROM item;");
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                System.out.println(
                result.getInt       ("id")           + ": " +
                result.getString    ("partNo")       + ": " +
                result.getString    ("serialNo")     + ": " +
                result.getString    ("name")         + ": " +
                result.getString    ("description")  + ": " +
                result.getInt       ("numberInStock")+ ": " +
                result.getBigDecimal("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}