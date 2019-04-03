package xin.tianchuang.common.component;

import io.jsonwebtoken.Claims;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xin.tianchuang.modules.app.utils.JwtUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {
    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void generateTokenTest() {
        String token = jwtUtils.generateToken(1);
        System.out.println(token);
    }
    
    @Test
    public void getClaimByTokenTest() {
        Claims claimByToken = jwtUtils.getClaimByToken("");
    }
    
}
