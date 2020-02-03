package dh.study.springbootstudyshiro.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;                // 主键
    @Column(unique = true)
    private String username;        // 登陆账号,唯一
    private String name;            // 用户名
    private String password;
    private String salt;

    @JsonIgnoreProperties(value = {"userInfos"})
    @ManyToMany(fetch = FetchType.EAGER)        // 立即从数据库中加载数据
    @JoinTable(
            name = "SysUserRole",
            joinColumns = @JoinColumn(name = "uid"),
            inverseJoinColumns = @JoinColumn(name = "rid")
    )
    private List<SysRole> roles;    // 一个用户有多个角色
}
