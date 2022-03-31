package hiber.controller;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.User;
//import hiber.repository.UserRepository;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private UserDao ud;
  //  private UserRepository ur;
    List<String> messages = new ArrayList<>();
    {
        messages.add("Helo!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
    }
//    AnnotationConfigApplicationContext context =
//            new AnnotationConfigApplicationContext(AppConfig.class);
//
//    UserService userService = context.getBean(UserService.class);
//    {
//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//    }
   //List<User> messages = ud.listUsers();
    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("I'm Spring MVC application");
//        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

}