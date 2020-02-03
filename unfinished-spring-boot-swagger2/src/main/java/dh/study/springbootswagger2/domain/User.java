package dh.study.springbootswagger2.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
    private static final long serialVersionUID = -2731598327208972274L;

    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("用户年龄")
    private Integer age;

}
