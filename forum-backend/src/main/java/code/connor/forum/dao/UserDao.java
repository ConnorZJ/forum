package code.connor.forum.dao;

import code.connor.forum.model.Role;
import code.connor.forum.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author Connor Xiong
 * @Date 2020-05-19 23:31
 */
@Repository
public interface UserDao {

    User loadUserByUsername(String username);

    List<Role> getUserRolesById(String id);
}
