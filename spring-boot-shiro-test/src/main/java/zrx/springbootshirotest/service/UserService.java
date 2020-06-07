package zrx.springbootshirotest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zrx.springbootshirotest.entity.User;
import zrx.springbootshirotest.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
