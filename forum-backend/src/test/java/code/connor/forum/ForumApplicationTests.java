package code.connor.forum;

import code.connor.forum.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ForumApplicationTests {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void contextLoads() {
        userDetailsService.loadUserByUsername("admin");
    }

}
