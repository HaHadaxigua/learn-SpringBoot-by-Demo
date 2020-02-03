package dh.study.springbootstudyshiro.custom;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    /**
     * 在方法开始前添加一个用户
     */
    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("zrx", "123");
    }

    @Test
    public void testAuthentication(){
        // 构建securityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager); // 获取securityManager环境
        Subject subject = SecurityUtils.getSubject();             // 获取当前subject

        UsernamePasswordToken token = new UsernamePasswordToken("zrx", "123");
        subject.login(token);

        System.out.println("isAuthentication:"+subject.isAuthenticated());
        subject.logout();
        System.out.println("isAuthentication:"+subject.isAuthenticated());

    }
}
