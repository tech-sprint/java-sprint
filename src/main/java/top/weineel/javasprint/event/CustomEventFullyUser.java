package top.weineel.javasprint.event;

import lombok.Getter;
import lombok.Setter;
import top.weineel.javasprint.domain.User;

/*
    完全自定义的事件类型
 */
public class CustomEventFullyUser extends CustomEventFully<User> {

    @Getter
    @Setter
    private boolean awesome;

    public CustomEventFullyUser(User source, boolean awesome) {
        super(source);
        this.awesome = awesome;
    }

}
