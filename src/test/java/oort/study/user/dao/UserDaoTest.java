package oort.study.user.dao;

import oort.study.connection.SimpleConnectionMaker;
import oort.study.factory.DaoFactory;
import oort.study.user.vo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class UserDaoTest {

    @Test
    void connectionTest() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "root");
        String schema = connection.getSchema();
        System.out.println(schema);
        connection.close();
    }
    @Test
    void add() throws SQLException {
        SimpleConnectionMaker simpleConnectionMaker = new SimpleConnectionMaker() {
            @Override
            public Connection makeConnection() throws SQLException {
                return DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "root");
            }
        };
        UserDao dao = new UserDao();
        dao.setSimpleConnectionMaker(simpleConnectionMaker);
        User user = new User();
        user.setId("root");
        user.setName("root");
        user.setPassword("1234");
        dao.add(user);
    }

    @Test
    void get() throws SQLException {
        UserDao dao = new DaoFactory().userDao();
        User root = dao.get("root");
        System.out.println(root.toString());
    }


}