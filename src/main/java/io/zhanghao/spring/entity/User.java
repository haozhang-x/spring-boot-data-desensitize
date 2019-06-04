package io.zhanghao.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.zhanghao.spring.utils.desensitize.annotation.Sensitive;
import io.zhanghao.spring.utils.desensitize.enums.SensitiveType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * User 实体类
 *
 * @author zhanghao
 * @date 2019/06/02
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private Long id;
    @Sensitive(SensitiveType.CHINESE_NAME)
    private String username;

    @Sensitive(SensitiveType.ID_CARD)
    private String idCard;

    @Sensitive(SensitiveType.PASSWORD)
    private String password;

    @Sensitive(SensitiveType.MOBILE)
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private Date birthday;
}
