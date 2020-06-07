package zrx.springbootshirotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zrx.springbootshirotest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
