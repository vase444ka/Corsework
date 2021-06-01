package app.dbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBC{
    private JDBC(){}

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(Config.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  DriverManager.getConnection(Config.getConnectionUrl(),
                Config.getUserName(), Config.getPassword());
    }
}
