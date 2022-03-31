package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

       UserService userService = context.getBean(UserService.class);
//
//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      //  UserDao userDao = context.getBean(UserDao.class);
        userService/*userDao*/.add(new User("vova", "ivanov", "vova@mail.ru"));
//        List<User> users = userDao.listUsers();
//        for (User user : users) {
//            System.out.println("Id = "+user.getId());
//            System.out.println("First Name = "+user.getFirstName());
//            System.out.println("Last Name = "+user.getLastName());
//            System.out.println("Email = "+user.getEmail());
//            // System.out.println("Car model = " + user.getCar().getModel());
//            System.out.println();
//        }

        context.close();
    }
}