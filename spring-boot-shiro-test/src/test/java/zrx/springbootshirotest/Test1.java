package zrx.springbootshirotest;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Test1 {
    @Test
    public void test() {
        String username = "zrx";
        String password = "123456";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithm = "SHA-256";
        String encodePassword = new SimpleHash(algorithm, password, salt, times).toString();
        System.out.println(encodePassword + "---" + salt);


    }
}
