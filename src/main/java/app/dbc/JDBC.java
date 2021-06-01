package app.dbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBC{
    static String config = "WEB-INF/db.conf";
    private JDBC(){}

    public static Connection getConnection(InputStream input) throws SQLException {
        Properties connInfo = new Properties();
        try {
            connInfo.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String connectionURL = connInfo.getProperty("connection.url");
        String username = connInfo.getProperty("user.name");
        String password = connInfo.getProperty("password");

        try {
            Class.forName(connInfo.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  DriverManager.getConnection(connectionURL, username, password);
    }
}
