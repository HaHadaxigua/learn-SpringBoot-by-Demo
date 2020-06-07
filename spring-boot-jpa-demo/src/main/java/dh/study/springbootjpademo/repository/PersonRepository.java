package dh.study.springbootjpademo.repository;

import dh.study.springbootjpademo.model.po.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // Optional 是个容器：它可以保存类型T的值，或者仅仅保存null;
    // 解决了空指针异常
    Optional<Person> findByName(String name);

    List<Person> findByAgeGreaterThan(int age);

    @Query("SELECT p FROM Person p where p.name=:name")
    Optional<Person> findByNameCustomQuery(@Param("name") String name);

    @Query("SELECT p.name FROM Person p where p.id=:id")
    Optional<Person> findPersonNameById(@Param("id") Long id);

    /**
     * 自定义更新语句
     *
     * @param name
     * @param id
     */
    @Modifying
    @Transactional
    @Query("UPDATE Person p set p.name=?1 where p.id=?2")
    void updatePersonNameById(String name, Long id);


}

// 这表明我们只要继承了JpaRepository<T, ID> 就具有了 JPA 为我们提供好的增删改查、分页查询以及根据条件查询等方法。
