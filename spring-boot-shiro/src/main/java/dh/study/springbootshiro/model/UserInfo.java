package dh.study.springbootshiro.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 用户信息表
 */
@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    private Integer uid;        // 数据库中的id
    @Column(unique = true)
    private String username;    // 账号
    private String name;        // 昵称
    private String password;    // 密码
    private String salt;        // 加密的盐
    private byte state;         // 用户状态  0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    @ManyToMany(fetch = FetchType.EAGER)    // 立即从数据库中加载数据
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}
