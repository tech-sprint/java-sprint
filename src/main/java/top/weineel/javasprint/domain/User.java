package top.weineel.javasprint.domain;

// lombok 的使用必须配合ide的插件
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
//import lombok.Getter;
//import lombok.Getter;

@Data  // 相当于同时添加Getter和Setter
@Accessors(chain = true)
@Slf4j
public class User implements InitializingBean, DisposableBean {

    // Getter Setter可以用在字段上
    private String username = "default weineel";

    private int age;

    public void init() {
        log.info("User({}) init, age = {}", username, age);
    }

    public void destroy1() {
        log.info("User({}) destroy1, age = {}", username, age);
    }

    @Override
    // 先于@Bean中声明的destroyMethod方法的调用
    public void destroy() {
        log.info("User({}) destroy, age = {}", username, age);
    }

    @Override
    // 先于@Bean中声明的initMethod方法的调用
    public void afterPropertiesSet() throws Exception {
        log.info("User({}) afterPropertiesSet, age = {}", username, age);
    }
}
