package code.connor.forum.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @Description 用户实体
 * @Author Connor Xiong
 * @Date 2020-05-13 22:08
 */
@Data
public class User extends BasePo {

    private static final long serialVersionUID = -4036985780376631274L;

    @NotNull
    private String username;


    private String nickname;

    @NotNull
    private String password;

    private String avatarUrl;

    @Email
    private String email;

    private String introduction;

    private String signature;

}
