package dh.study.springbootstudyshiro.service.impl;

import dh.study.springbootstudyshiro.dao.UserInfoDao;
import dh.study.springbootstudyshiro.entity.UserInfo;
import dh.study.springbootstudyshiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
