package top.weineel.javasprint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import top.weineel.javasprint.domain.School;
import top.weineel.javasprint.domain.User;

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
        /*
        使用ApplicationListener 中的泛型类型来区分不同的事件类型。
         */
        app.addListeners((ApplicationListener<ApplicationStartingEvent>) event -> {
            System.out.println("ApplicationStartingEvent System.out: " + event.getTimestamp());
            // 由于刚启动ApplicationContext还没有初始化完成，所以还没有注入log，无法打印出下面一行
            log.info("ApplicationStartingEvent: " + event.getTimestamp());
        }, (ApplicationListener<ApplicationReadyEvent>) event -> log.info("ApplicationReadyEvent: " + event.getTimestamp()));
//        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.getBean()
    }

    /*
        # 在有@Configuration注解的类中，声明Bean。
        * 返回值是配置完成的Bean，默认Bean的名字(id)为方法名，但是获取Bean时可能不使用Bean名字而是直接使用类似 context.getBean(CommandLineRunner.class) 方法。
        * 传入的参数是Bean依赖，即已经注册的其它Bean。可以是@Bean注解方法配置的，也可以是@Component等注解配置的。
     */
    @Bean
    // CommandLineRunner 这个Bean会在Spring boot初始化完成后调用。[参考](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html#boot-features-command-line-runner)
    // Spring容器根据类型获取这个Bean，函数名会被忽略。
    public CommandLineRunner commandLineRunner(School school) {
        return args -> log.info("CommandLineRunner: schoolName = {}", school.getName());
    }

    // 可以指定bean的生命周期钩子函数，在bean的实现类中实现。
    @Bean(name = "user", initMethod = "init", destroyMethod = "destroy")
    public User user() {
        return new User().setAge(27);
    }
}
