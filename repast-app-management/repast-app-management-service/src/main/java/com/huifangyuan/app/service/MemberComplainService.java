package com.huifangyuan.app.service;

import com.huifangyuan.app.base.BaseService;
import com.huifangyuan.app.domain.Member;
import com.huifangyuan.app.domain.MemberComplain;
import com.huifangyuan.app.mapper.MemberComplainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Whc
 * @Date 2019/11/25 21:27
 * @Description
 **/

@Service
public class MemberComplainService extends BaseService<MemberComplain> {

    @Autowired
    private MemberComplainMapper memberComplainMapper;

    @Autowired
    private MemberCommentService memberCommentService;

    @Override
    public Mapper<MemberComplain> getMapper() {

        return memberComplainMapper;
    }

    /**
     * 添加意见信息功能
     * @param complain
     * @return
     */
    public Boolean addComplain(MemberComplain complain, String token,MemberCommentService memberCommentService) {
        if(null != token || !"".equals(token)){
            Member member = memberCommentService.memberToken(token);
            if(null == member){
                return false;
            }
            complain.setMemberId(member.getId());
            complain.setMemberNickName(member.getNickname());
            //********
            //获取当前时间
            Date date = new Date();
            String formatDate = null;
            //HH表示24小时制；
            DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formatDate = dFormat.format(date);
            SimpleDateFormat lsdStrFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date strD = null;
            try {
                strD = lsdStrFormat.parse(formatDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(strD+"======================");
            complain.setCreateTime(strD);
            int insert = memberComplainMapper.insert(complain);
            if (insert > 0) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
