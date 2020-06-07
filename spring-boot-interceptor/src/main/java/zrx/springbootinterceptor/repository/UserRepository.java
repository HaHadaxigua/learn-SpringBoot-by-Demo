package zrx.springbootinterceptor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zrx.springbootinterceptor.entity.Person;
import zrx.springbootinterceptor.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Person> findByName(String name);       //  Optional 类的引入很好的解决空指针异常。 值可以为null

    List<Person> findByAgeGreaterThan(int age);

    @Query("select u from User u where u.name = :name")
        // 自定义查询
    Optional<Person> findByNameCustomerQuery(String name);

    @Query("select u.name from User u where u.id = :id")
    String findUsernameById(long id);
}
