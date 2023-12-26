package oort.study.tobyspring;

import oort.study.factory.DaoFactory;
import oort.study.user.dao.UserDao;
import oort.study.user.vo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class TobyspringApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext ac = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = ac.getBean("userDao", UserDao.class);
        User root = dao.get("root");
        System.out.println(root);
    }

}
