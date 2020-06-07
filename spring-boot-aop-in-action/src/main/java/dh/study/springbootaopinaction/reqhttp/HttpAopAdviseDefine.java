package dh.study.springbootaopinaction.reqhttp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HttpAopAdviseDefine {
    // 定义一个 Pointcut, 使用 切点表达式函数 来描述对哪些 Join point 使用 advise.
    @Pointcut("@annotation(dh.study.springbootaopinaction.reqhttp.AuthChecker)")
    public void pointcut() {
    }

    // 定义advice
    // 当被 AuthChecker 注解所标注的方法调用前, 会执行我们的这个 advice,
    @Around("pointcut()")
    public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        String user_token = getUserToken(request);
        if (!user_token.equalsIgnoreCase("123"))
            return "错误，权限不合法";
        return joinPoint.proceed();
    }

    private String getUserToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("user_token"))
                return cookie.getValue();
        }
        return "";
    }

}
