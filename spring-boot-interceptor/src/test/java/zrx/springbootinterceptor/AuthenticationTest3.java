package zrx.springbootinterceptor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import zrx.springbootinterceptor.realm.MyRealm2;

public class AuthenticationTest3 {
    @Test
    public void test3() {
        MyRealm2 myRealm = new MyRealm2();

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zrx", "123");
        subject.login(usernamePasswordToken);

        subject.checkPermissions("user:delete", "user:add");
        subject.checkRoles("admin", "test");
        subject.logout();
    }

    @Test
    public void testEncryption() {
        String password = "123456";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithm = "SHA-256";
        String encodePassword = new SimpleHash(algorithm, password, salt, times).toString();
        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ", password, salt, times, encodePassword);
    }
}
