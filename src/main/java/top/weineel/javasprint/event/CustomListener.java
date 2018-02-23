package top.weineel.javasprint.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*
    * 这个类最低层继承java.util.EventListener这个标记性接口。
    * 注册为Bean实现对应的接口指定泛型事件类型就可以，进行事件监听了，不需要手动addListeners。
    * 但是类似于ApplicationStartingEvent在ApplicationContext没初始化前就发生的事件，需要在应用中手动添加，示例，查看类JavaSprintApplication的实现
 */

@Component
@Slf4j
// ApplicationListener 中的泛型类型可以区别不同的事件类型
// [ApplicationReadyEvent](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html#boot-features-application-events-and-listeners)
public class CustomListener implements ApplicationListener<ApplicationReadyEvent>{
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("CustomListener ApplicationReadyEvent: " + event.getTimestamp());
    }
}
