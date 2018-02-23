package top.weineel.javasprint.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// 基于注解的事件监听
@Slf4j
@Component
public class AnnotationEventListener {

    @EventListener
    public void handleApplicationReady(ApplicationReadyEvent event) {
        log.info("AnnotationEventListener handleApplicationReady: {}", event.getTimestamp());
    }

    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        log.info("AnnotationEventListener handleCustomEvent: username = {}", event.getSource());
    }

    @EventListener
    public void handleCustomFully(CustomEventFully event) {
        log.info("AnnotationEventListener handleCustomFully: user = {}", event.getSource());
    }

    /*
        使用SpEL
        [Spring Expression Language](https://docs.spring.io/spring/docs/4.2.x/spring-framework-reference/html/expressions.html)
     */
    @EventListener(condition = "#event.awesome")
    public void handleCustomFully1(CustomEventFullyUser event) {
        log.info("AnnotationEventListener CustomEventFullyUser1: event.awesome = {}, username = {}", event.isAwesome(), event.getSource().getUsername());
    }

    @EventListener(condition = "#event.getSource().getUsername() == 'weineel'")
    public void handleCustomFully2(CustomEventFullyUser event) {
        log.info("AnnotationEventListener CustomEventFullyUser2: event.awesome = {}, username = {}", event.isAwesome(), event.getSource().getUsername());
    }
}
