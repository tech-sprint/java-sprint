package top.weineel.javasprint.domain;

// lombok 的使用必须配合ide的插件
import lombok.Data;
import lombok.experimental.Accessors;
//import lombok.Getter;
//import lombok.Getter;

@Data  // 相当于同时添加Getter和Setter
@Accessors(chain = true)
public class User {

    // Getter Setter可以用在字段上
    private String username;

    private int age;
}
