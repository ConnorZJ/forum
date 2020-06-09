package code.connor.forum.controller;

import code.connor.forum.model.RespResult;
import code.connor.forum.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @PostMapping("/register")
    public RespResult register(HttpServletRequest request, @RequestBody User user) {
        System.out.println(user);
        return RespResult.success();
    }

}
