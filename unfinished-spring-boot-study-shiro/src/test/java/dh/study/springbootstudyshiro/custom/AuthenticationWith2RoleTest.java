package dh.study.springbootstudyshiro.custom;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;


public class AuthenticationWith2RoleTest {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("zrx", "123", "admin", "user");
    }

    @Test
    public void testAuthentication(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zrx","123");
        subject.login(usernamePasswordToken);
        System.out.println("isAuthentication: "+subject.isAuthenticated());

        subject.checkRoles("admin", "user");
        subject.checkRole("xxx");



    }

}
