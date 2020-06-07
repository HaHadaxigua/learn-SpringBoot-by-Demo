package zrx.springbootinterceptor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationTest {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
    Logger logger = LoggerFactory.getLogger(AuthenticationTest.class);

    @Before
    public void addUser() {
        logger.info("在测试方法开始前添加一个用户");
        simpleAccountRealm.addAccount("zrx", "123");
    }

    @Test
    public void testAuthentication() {
        // 1. 构建securityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2. 主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);   // 设置securityManager
        Subject subject = SecurityUtils.getSubject();               // 获取当前主体

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zrx", "123");
        subject.login(usernamePasswordToken);                       // 登陆

        logger.info("是否已经认证：" + subject.isAuthenticated());      // 判断是否登陆
        subject.logout();
        logger.info("是否已经认证: " + subject.isAuthenticated());
    }
}
