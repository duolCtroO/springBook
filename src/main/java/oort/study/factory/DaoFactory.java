package oort.study.factory;

import oort.study.connection.SimpleConnectionMaker;
import oort.study.user.dao.UserDao;
import oort.study.user.vo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao(){
        UserDao dao = new UserDao();
        dao.setSimpleConnectionMaker(getConnectionMaker());
        return dao;
    }

    @Bean
    public SimpleConnectionMaker getConnectionMaker(){
        return new SimpleConnectionMaker() {
            @Override
            public Connection makeConnection() throws SQLException {
                return DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "root");
            }
        };

    }
}
