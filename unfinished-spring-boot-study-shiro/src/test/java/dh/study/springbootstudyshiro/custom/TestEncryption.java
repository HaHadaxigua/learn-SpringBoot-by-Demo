package dh.study.springbootstudyshiro.custom;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class TestEncryption {
    @Test
    public void showEncryption(){
        String password = "123456";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmType = "md5";
        String encodePassword = new SimpleHash(algorithmType, password, salt, times).toString();
        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ",password,salt,times,encodePassword);


    }
}
