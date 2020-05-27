package code.connor.forum.controller;

import code.connor.forum.model.RespResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Connor Xiong
 * @Date 2020-05-27 23:41
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public RespResult login() {
        return RespResult.fail("尚未登录");
    }

}
