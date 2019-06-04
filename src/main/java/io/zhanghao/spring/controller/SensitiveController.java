package io.zhanghao.spring.controller;

import io.zhanghao.spring.entity.User;
import io.zhanghao.spring.utils.ResultVOUtils;
import io.zhanghao.spring.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 敏感数据演示
 *
 * @author zhanghao
 * @date 2019/06/02
 */
@RestController
@RequestMapping("user")
public class SensitiveController {


    /**
     * "code": 200,
     * "msg": "OK",
     * "data": [
     * {
     * "username": "us*ser0",
     * "idCard": "00***********0000",
     * "password": "******",
     * "phone": "18****0000",
     * "birthday": "2019-06-04 11:12:19 下午"
     * },
     * {
     * "username": "us*ser1",
     * "idCard": "00***********0001",
     * "password": "******",
     * "phone": "18****0001",
     * "birthday": "2019-06-04 11:12:19 下午"
     * },
     * {
     * "username": "us*ser2",
     * "idCard": "00***********0002",
     * "password": "******",
     * "phone": "18****0002",
     * "birthday": "2019-06-04 11:12:19 下午"
     * }
     * ]
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setPhone("1850000000" + i)
                    .setBirthday(new Date())
                    .setUsername("user" + i)
                    .setPassword("12345678900000")
                    .setIdCard("00000000000000000" + i);
            users.add(user);
        }

        return ResultVOUtils.success(users);
    }


}
