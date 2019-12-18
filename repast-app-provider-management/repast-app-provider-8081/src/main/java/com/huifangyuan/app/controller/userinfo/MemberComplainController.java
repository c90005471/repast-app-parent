package com.huifangyuan.app.controller.userinfo;

import com.huifangyuan.app.domain.MemberComplain;
import com.huifangyuan.app.service.MemberCommentService;
import com.huifangyuan.app.service.MemberComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Whc
 * @Date 2019/11/25 21:26
 * @Description
 **/

@RestController
public class MemberComplainController {

    @Autowired
    private MemberComplainService memberComplainService;

    @Autowired
    private MemberCommentService memberCommentService;

    /**
     * 添加用户意见信息
     * @param complain
     * @return
     */
    @PostMapping("/addComplain")
    public Boolean addComplain(@RequestBody MemberComplain complain, @RequestParam("token") String token){

        if(memberComplainService.addComplain(complain,token,memberCommentService)){
            return true;
        }else{
            return false;
        }
    }

}
