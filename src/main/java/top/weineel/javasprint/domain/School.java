package top.weineel.javasprint.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Data
@Component
@Slf4j
// 实现接口的方式，指定Bean生命周期方法。
public class School implements DisposableBean, InitializingBean {
    private String name = "school name";
    private String schoolmaster;

    @Override
    public void destroy() throws Exception {
        log.info("School({}) destroy", name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("School({}) afterPropertiesSet", name);
    }
}
