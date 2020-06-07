package zrx.springbootreadproperties;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zrx.springbootreadproperties.pojo.Person;

/**
 * 这里面无法读取
 * 因为我们没有启动spring boot的服务
 * 即 person没有被自动装配
 */
public class TestReadYml {
    @Autowired
    Person person;

    @Test
    public void readProperties() {
        System.out.println(person);
    }
}
