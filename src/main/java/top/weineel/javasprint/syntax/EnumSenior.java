package top.weineel.javasprint.syntax;


enum Colors {
    Red(1, "红色"), Green(2, "绿色"), Blue(3, "蓝色");

    private int _value;
    private String _name;

    Colors(int value, String name) {
        _value = value;
        _name = name;
    }

    public int value() {
        return _value;
    }

    public String getName() {
        return _name;
    }

    @Override
    public String toString() {
        return super.toString() + ":weineel";
    }
}

public class EnumSenior {
    public static void main(String[] arg) {
        System.out.println(Colors.Blue);  // 调用toString方法。
        System.out.println(Colors.Blue.value());
    }
}
