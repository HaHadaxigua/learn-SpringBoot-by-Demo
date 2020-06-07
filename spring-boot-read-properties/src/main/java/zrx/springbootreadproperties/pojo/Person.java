package zrx.springbootreadproperties.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "person")
@NoArgsConstructor
@Validated
public class Person {
    @Value("person.name")
    private String name;
    private int age;
    private Map<String, Object> map;
    private List<String> list;
    @Email()        // JSR303校验
    private String email;

    public Person(String name, int age, Map<String, Object> map, List<String> list) {
        this.name = name;
        this.age = age;
        this.map = map;
        this.list = list;
    }
}
