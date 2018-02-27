package top.weineel.javasprint.syntax;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeclareClassesTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void initial() {
        DeclareClasses d1 = new DeclareClasses();
        // 类加载完成，执行静态代码块
        Assert.assertEquals(1, DeclareClasses.count);
        // 初始化对象后, 执行代码块
        Assert.assertEquals("weineel", d1.getName());

        DeclareClasses d2 = new DeclareClasses();
        // 静态代码块只执行一次
        Assert.assertNotEquals(2, DeclareClasses.count);
        // 初始化对象后, 执行代码块
        Assert.assertEquals("weineel", d2.getName());
    }

    // 匿名方式 声明内部类 -> 匿名内部类
    @Test
    public void anonymousClass() {
        // 先执行父类的代码块。
        DeclareClasses d = new DeclareClasses() {{
            setDescription("www");
            System.out.println("DeclareClasses anonymousClass: count=" + count);
        }};
        Assert.assertEquals("www", d.getDescription());
        Assert.assertEquals("weineel", d.getName());

        DeclareClasses dd = new DeclareClasses() {
//            static {
//                System.out.println("DeclareClasses anonymousClass: count=" + count);
//            }

            // 重写匿名内部类方法
            @Override
            public String getDescription() {
                return "hhh";
            }

            {
                setDescription("www");
                setName("weineel1");
                System.out.println("DeclareClasses anonymousClass: count=" + count);
            }

        };

        Assert.assertEquals("hhh", dd.getDescription());
        Assert.assertEquals("weineel1", dd.getName());
    }

}
