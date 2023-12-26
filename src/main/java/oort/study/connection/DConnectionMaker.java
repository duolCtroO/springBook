package oort.study.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements SimpleConnectionMaker{
    @Override
    public Connection makeConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "root");
    }
}
