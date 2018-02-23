package top.weineel.javasprint.event;

import lombok.Getter;

/*
    完全自定义的事件类型
 */
public class CustomEventFully<T> {
    @Getter
    T source;

    public CustomEventFully(T source) {
        this.source = source;
    }
}
