package zrx.springbootshirotest.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping
@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping({"/", "/index"})
    public String home() {
        return "/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map, Model model) {
        logger.info("HomeController.login()");
        String exceptionDesc = (String) request.getAttribute("shiroLoginFailure");
        logger.error("error:" + exceptionDesc);
        String msg = "";
        if (exceptionDesc != null) {
            if (UnknownAccountException.class.getName().equals(exceptionDesc)) {
                msg = UnknownAccountException.class.getName();
                logger.error(msg + "--->账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionDesc)) {
                msg = IncorrectCredentialsException.class.getName();
                logger.error(msg + "--->账号或密码错误");
            } else if ("kaptchaValidateFailed".equals(exceptionDesc)) {
                msg = "kaptchaValidateFailed";
                logger.error(msg + "--->验证码错误");
            } else {
                msg = "else >> " + exceptionDesc;
                logger.error(msg);
            }
            map.put("msg", msg);
        }
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(Model model) {
        logger.info("没有权限");
        return "/403";
    }
}
