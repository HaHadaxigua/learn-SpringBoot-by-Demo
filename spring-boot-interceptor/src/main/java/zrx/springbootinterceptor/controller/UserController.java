package zrx.springbootinterceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrx.springbootinterceptor.entity.User;
import zrx.springbootinterceptor.result.Response;
import zrx.springbootinterceptor.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/ulist")
    public Response ulist(HttpServletResponse response) {
        List<User> list = userService.findAllUser();
        if (list.size() != 0)
            return new Response(999, response.getStatus(), "access /api/ulist to get user list", Instant.now(), list);
        else
            return new Response(998, response.getStatus(), "table user is empty", Instant.now(), list);
    }

    @GetMapping("/uinitial")
    public Response uinitial(HttpServletResponse response) {
        userService.initialUserTable();
        return new Response(999, response.getStatus(), "access /api/ulist to get user list", Instant.now(), "initial table");
    }
}
