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

    List<String> messages = new ArrayList<>();
    {
        messages.add("Helo!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {

        model.addAttribute("messages", messages);
        return "index";
    }

}