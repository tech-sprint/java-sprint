package top.weineel.javasprint.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * top.weineel.javasprint.controller.Home.*(..))")
    private void startLogger() {}

    @Before(value = "startLogger()")
    public void startLoggerBefore(JoinPoint joinpoint) {
        logger.info("spring aop startLogger " + joinpoint.toString());
    }

}
