package zrx.springbootinterceptor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zrx.springbootinterceptor.entity.User;
import zrx.springbootinterceptor.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void initialUserTable() {
        for (int i = 0; i < 10; i++) {
            userRepository.save(new User("zrx" + i, i + 18));
        }
    }

    public List<User> findAllUser() {
        List<User> list = userRepository.findAll();
        return list;
    }
}
