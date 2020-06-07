package zrx.springbootinterceptor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest2 {
    SimpleAccountRealm realm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        realm.addAccount("zrx", "123");
        realm.addAccount("dh", "1", "admin", "ceo");
    }

    @Test
    public void authentication() {
        // SecurityManager 负责真正的身份验证逻辑；它会委托给 Authenticator 进行身份验证；
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zrx", "123");
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("dh", "1");
        subject.login(usernamePasswordToken);
        System.out.println(subject.isAuthenticated());
        subject.checkRoles("admin", "ceo");
        subject.logout();
        System.out.println(subject.isAuthenticated());

    }
}
