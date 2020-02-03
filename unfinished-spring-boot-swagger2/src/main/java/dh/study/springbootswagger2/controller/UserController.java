package dh.study.springbootswagger2.controller;

import dh.study.springbootswagger2.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Api(value = "用户Controller")
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @ApiIgnore              // api文档忽略这个方法
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @ApiOperation(value = "获取用户", notes = "获取用户")
    @GetMapping("/{id}")
    public @ResponseBody User getUserById(@PathVariable(value = "id")long id){
        User user = new User();
        user.setId(id);
        user.setName("dh");
        user.setAge(22);
        return user;
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("/list")
    public List<User> getUserList(){
        List<User> list = new LinkedList<>();
        User user1 = new User();
        user1.setId(1l);
        user1.setName("mrbird");
        user1.setAge(25);
        list.add(user1);
        User user2 = new User();
        user2.setId(2l);
        user2.setName("scott");
        user2.setAge(29);
        list.add(user2);
        return list;
    }

    @ApiOperation(value = "新增用户", notes = "根据用户实体创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/add")
    public  Map<String, Object> addUser(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public  Map<String, Object> deleteUser(@PathVariable(value = "id") Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    @ApiOperation(value = "更新用户", notes = "根据用户id更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User") })
    @PutMapping("/{id}")
    public Map<String, Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }
}
