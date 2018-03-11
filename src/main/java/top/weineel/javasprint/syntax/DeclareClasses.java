package top.weineel.javasprint.syntax;

/**
 * test 中测试类的声明
 */
public class DeclareClasses {

    private String name;

    private String description;

    static public int count = 0;

    // 静态代码块，类第一次加载完成后执行。只能访问静态变量
    static {
        System.out.println("DeclareClasses class init: count=" + count);
        count += 1;
    }

    // 实例代码块，对象初始化完成后执行。
    {
        setName("weineel2");
        setDescription("我的名字");
        System.out.println("DeclareClasses object init: count=" + count);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    {
        setName("weineel");
    }
}
