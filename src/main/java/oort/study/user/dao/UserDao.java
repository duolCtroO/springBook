package oort.study.user.dao;

import oort.study.connection.SimpleConnectionMaker;
import oort.study.user.vo.User;

import java.sql.*;

public class UserDao {
    private SimpleConnectionMaker simpleConnectionMaker;

    public void setSimpleConnectionMaker(SimpleConnectionMaker simpleConnectionMaker){
        this.simpleConnectionMaker = simpleConnectionMaker;
    }

    public void add(User user) throws SQLException {
        Connection c = simpleConnectionMaker.makeConnection();
        PreparedStatement p = c.prepareStatement("insert into USER(id, name, password) values(?, ?, ?)");
        p.setString(1, user.getId());
        p.setString(2, user.getName());
        p.setString(3, user.getPassword());
        p.executeUpdate();

        p.close();
        c.close();
    }

    public User get(String userId) throws SQLException {
        Connection c = simpleConnectionMaker.makeConnection();
        PreparedStatement p = c.prepareStatement("select * from USER where id = ?");
        p.setString(1, userId);
        ResultSet rs = p.executeQuery();

        User user = new User();
        rs.next();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        p.close();
        c.close();

        return user;
    }

}
