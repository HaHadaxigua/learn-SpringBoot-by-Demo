package dh.study.springbootjackson.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dh.study.springbootjackson.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(path = "/json")
public class TestJsonController {
    @Autowired
    ObjectMapper mapper;

    @RequestMapping(path = "/getUser")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setName("mrbird");
        user.setBirthday(new Date());
        return user;
    }

    /**
     * 对象序列化
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(path = "/serialization")
    @ResponseBody
    public String serialization() throws JsonProcessingException {
        User u = new User();
        u.setName("dh");
        u.setBirthday(new Date());
        return mapper.writeValueAsString(u);
    }

    /**
     * 反序列化
     * 当采用树遍历的方式时，JSON被读入到JsonNode对象中，可以像操作XML DOM那样读取JSON。
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(path = "/readJsonString")
    @ResponseBody
    public String readJsonString() throws JsonProcessingException {
//        String json = "{\"name\":\"dh\",\"age\":\"22\"}";
        String json = "{\"name\":\"mrbird\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";
        ;
        JsonNode node = this.mapper.readTree(json);
        String name = node.get("name").asText();
        int age = node.get("age").asInt();
        // 多级Json的情况
        JsonNode hobby = node.get("hobby");
        String first_hobby = hobby.get("first").asText();
        return name + " " + age;
    }

    /**
     * 将Json与对象进行绑定
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(path = "/readJsonAsObject")
    @ResponseBody
    public String readJsonAsObject() throws JsonProcessingException {
        String json = "{\"name\":\"mrbird\",\"age\":26}";
        User user = mapper.readValue(json, User.class);
        String name = user.getName();
        int age = user.getAge();
        return name + "" + age;
    }

}
