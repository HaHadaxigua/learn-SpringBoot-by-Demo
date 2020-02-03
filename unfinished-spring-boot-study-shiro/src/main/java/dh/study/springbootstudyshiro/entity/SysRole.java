package dh.study.springbootstudyshiro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.security.Permission;
import java.util.List;

@Data
@Entity
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;        // 主键
    private String name;    // 角色名
    private String desc;    // 角色描述

    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany
    @JoinTable(
            name = "SysUserRole",
            joinColumns = @JoinColumn(name = "rid"))
    private List<UserInfo> userInfos;           // 一个角色可以有多个用户

    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany
    @JoinTable(
            name = "SysRolePermission",
            joinColumns = @JoinColumn(name = "rid"),
            inverseJoinColumns = @JoinColumn(name = "pid"))
    private List<SysPermission> permissions;       // 一个角色可以有多个权限
}
