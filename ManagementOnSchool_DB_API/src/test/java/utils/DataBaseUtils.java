package utils;

import java.sql.*;

public class DataBaseUtils {

    public static ResultSet getResultSet(String sqlQuery){
        //Create connection
        Connection connection;
        //Create Statement
        Statement statement;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
            statement = connection.createStatement();} catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Create ResultSet
        try {
            return statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
