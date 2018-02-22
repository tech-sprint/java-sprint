package top.weineel.javasprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.weineel.javasprint.domain.User;

@Controller
@RequestMapping("/home")
public class Home {

    @ResponseBody
    @GetMapping("/{username}")
    public String hello(@PathVariable("username") String username) {
        System.out.println("hello");
        User user = new User();
        user.setUsername(username).setAge(18);
        return "hello " + user.getUsername() + user.getAge();
    }
}
