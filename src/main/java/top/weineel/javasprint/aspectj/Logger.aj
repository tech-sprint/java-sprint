package top.weineel.javasprint.aspectj;
import org.slf4j.LoggerFactory;


/*
    没有测试通过
 */
public aspect Logger {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

//    pointcut endLogPointcut():execution(* top.weineel.javasprint.controller.Home.*());
//
//    after():endLogPointcut() {
//        logger.error("aspectj endLogger");
//        System.out.println("Log Recoding");
//    }

    void around():call(* top.weineel.javasprint.controller.Home.*()) {
        System.out.println("Transaction Begin");
        proceed();
        System.out.println("Transaction End");
    }
}
