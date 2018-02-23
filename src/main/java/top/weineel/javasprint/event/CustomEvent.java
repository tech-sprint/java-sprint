package top.weineel.javasprint.event;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    /**
     * 在初始化的时候传入 payload（source）
     *
     * @param source the object on which the event initially payload
     */
    public CustomEvent(Object source) {
        super(source);
    }
}
