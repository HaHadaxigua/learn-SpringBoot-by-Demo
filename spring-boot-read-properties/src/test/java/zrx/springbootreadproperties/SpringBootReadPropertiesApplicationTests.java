package zrx.springbootreadproperties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zrx.springbootreadproperties.pojo.Person;

@SpringBootTest
class SpringBootReadPropertiesApplicationTests {
    @Autowired
    Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
