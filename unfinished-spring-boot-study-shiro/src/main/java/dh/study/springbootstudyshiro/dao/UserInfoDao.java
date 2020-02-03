package dh.study.springbootstudyshiro.dao;

import dh.study.springbootstudyshiro.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);
}
