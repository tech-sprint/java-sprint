package top.weineel.javasprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.weineel.javasprint.domain.User;
import top.weineel.javasprint.event.CustomEvent;
import top.weineel.javasprint.event.CustomEventFullyUser;

@Controller
@RequestMapping("/home")
public class Home {

    private final ApplicationEventPublisher publisher;

    @Autowired
    public Home(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @ResponseBody
    @GetMapping("/{username}")
    public String hello(@PathVariable("username") String username) {
        System.out.println("hello");
        User user = new User();
        user.setUsername(username).setAge(18);
        return "hello " + user.getUsername() + user.getAge();
    }

    @ResponseBody
    @GetMapping("/publish/{username}/{awesome}")
    public String publishUsername(@PathVariable("username") String username, @PathVariable("awesome") boolean awesome) {
        // 根据传入对象的类型和值区分不同的事件，匹配不同的handle（handle 注册在bean中）
        this.publisher.publishEvent(new CustomEvent(username));
        User user = new User();
        user.setUsername(username).setAge(18);
        this.publisher.publishEvent(new CustomEventFullyUser(user, awesome));
        return "publish " + username;
    }
}
