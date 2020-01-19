package dh.study.springbootjackson.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 6222176558369919436L;

    private String name;
    private int age;
    private String password;
    private Date birthday;
}
