package com.huifangyuan.app.controller.userinfo;

import com.huifangyuan.app.domain.Member;
import com.huifangyuan.app.service.MemberService;
import com.huifangyuan.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 9:36
 * @Description
 **/
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private RedisService redisService;
    @PostMapping("/userMessage")
    public  String newUser(@RequestBody Member member)throws Exception{
        return memberService.newUser(member);
    }

    /**
     * 执行登录
     * @param member
     * @return
     */
    @PostMapping("/login")
    public String doLogin(@RequestBody Member member) throws Exception {
        return memberService.doLogin(member);
    }

}
