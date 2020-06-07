package dh.study.springbootjpademo.repository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith("SpringRunner.class")
@SpringBootTest

public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    private Long id;

    @Before
    public void setUp() {
        assertNotNull();
    }


}
