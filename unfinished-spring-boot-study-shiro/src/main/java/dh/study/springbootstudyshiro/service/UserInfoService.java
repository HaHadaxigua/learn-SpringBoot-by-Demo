package dh.study.springbootstudyshiro.service;

import dh.study.springbootstudyshiro.entity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoService {
    public UserInfo findByUsername(String username);
}
