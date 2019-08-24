package cn.nmmpa.user;

import cn.nmmpa.token.core.Authoriz;
import cn.nmmpa.token.vo.TokenBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 17:31
 * @Version 1.0
 */
@RestController("/")
public class TestController {

    @Autowired
    private Authoriz authoriz;

    @GetMapping
    public String getToken(){
        TokenBody tokenBody = new TokenBody();
        tokenBody.setCacheKey("USER:1000000001");
        return authoriz.createToken(tokenBody);
    }
}
