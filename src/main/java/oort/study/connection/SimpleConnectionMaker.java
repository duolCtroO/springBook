package oort.study.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface SimpleConnectionMaker {
    public Connection makeConnection() throws SQLException;

}
