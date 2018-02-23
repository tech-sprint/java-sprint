package top.weineel.javasprint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication  // 同时包含了@Configuration、@EnableAutoConfiguration、@ComponentScan三个注解
@Slf4j
public class JavaSprintApplication {

    /*
    初始化构造方法
    Spring Boot 内部使用
    ```
    ApplicationContext context = new AnnotationConfigApplicationContext(JavaSprintApplication.class);
    ```
    方式初始化ApplicationContext
     */
    public JavaSprintApplication() {
        log.info("JavaSprintApplication init");
    }

    public static void main(String[] args) {
        /*
        # 参考
        - [Spring整理系列(11)——@Configuration注解、@Bean注解以及配置自动扫描、bean作用域](http://blog.csdn.net/javaloveiphone/article/details/52182899)
        - [Customizing SpringApplication](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html#boot-features-customizing-spring-application)
        # 代码解释
        SpringApplication.run 第一个参数为被@Configuration注解的类，用于自定义spring bean配置。
        */
//        SpringApplication.run(JavaSprintApplication.class, args);

//      自定义
        SpringApplication app = new SpringApplication(JavaSprintApplication.class);
        app.addListeners();
//        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.getBean()
    }
}
