package zrx.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "用户类")
public class User {

    @ApiModelProperty(value = "ID", example = "100")
    private Integer id;

    @ApiModelProperty(value = "姓名", example = "laolunsi")
    private String name;

    @ApiModelProperty(value = "是否启用", example = "1")
    private Boolean enable;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    public User(Integer id, String name, Boolean enable, Date updateTime) {
        this.id = id;
        this.name = name;
        this.enable = enable;
        this.updateTime = updateTime;
    }
}

