package dh.study.springbootstudyshiro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SysPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;            // 权限名称
    private String description;     // 权限描述,用于UI显示
    private String url;             // 权限地址.

    @JsonIgnoreProperties(value = {"permission"})
    @ManyToMany
    @JoinTable(
            name = "SysRolePermission",
            joinColumns = @JoinColumn(name = "pid"))
    private List<SysRole> roles;    // 一个权限可以被多个角色使用
}
