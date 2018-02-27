package top.weineel.javasprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.weineel.javasprint.event.CustomEventFullyUser;
import top.weineel.javasprint.domain.User;
import top.weineel.javasprint.event.CustomEvent;

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

    @ResponseBody
    @GetMapping("/brace")
    public String brace() {
        // 创建一个新的匿名类，并重写方法。并用这个匿名类创建对象。
        User u1 = new User() {
            @Override
            public int getAge() {
                return 3;
            }
            {
                setUsername("weineel me");
            }
        };
        u1.setAge(5);
        return "brace: age=" + u1.getAge() + ",username=" + u1.getUsername();
    }
}
