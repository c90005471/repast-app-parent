package com.huifangyuan.app.service;

import com.huifangyuan.app.base.BaseService;
import com.huifangyuan.app.domain.Member;
import com.huifangyuan.app.mapper.MemberMapper;
import com.huifangyuan.app.utils.IDUtil;
import com.huifangyuan.app.utils.JSONUtil;
import com.huifangyuan.app.vo.MemberAndLevelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import static com.huifangyuan.app.staticstatus.StaticProperties.OK;
import static com.huifangyuan.app.staticstatus.StaticProperties.REDIS_KEY;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 9:37
 * @Description
 **/
@Service
public class MemberService extends BaseService<Member> {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }
    /**
     * @Author 张威
     * @Description
     * @Param  * @param token
     * @Return java.lang.Long
     * @Date 2019/12/5
     */

    public Long getMemberId(String token){
        Member member = new Member();
        member.setToken(token);
        try {
            Member member1 = super.selectOne(member);
            return member1.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

  /*  *//**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @date 2019/11/21
     * @return java.lang.Boolean
     * @throws
    **//*
    public Boolean doLogin(Member member, RedisService redisService) {
        try {
            Member mbr = super.selectOne(member);
            if(null != mbr) {
                // 说明从数据库中查询到数据，说明登录成功
                // 应该把用户对象存入session中，session跨域了，就使用redis解决(redis也有问题)
                mbr.setPassword(null);
                String mbrString = JSONUtil.toJsonString(mbr);
                String setResult = redisService.set(REDIS_KEY, mbrString);
                if(OK.equals(setResult.toUpperCase())) {
                    // 说明redis存入成功
                    return true;
                }
                *//**
                 * 如果涉及到session的跨域:
                 *      如果是ajax，session跨域传递数据必须使用jsonp
                 *      如果是常规的调用:
                 *          1.把user对象存到redis中，也就是说redis就相当于session，然后把redis的key存入到cookie中
                 *          2.自己百度session的全局配置
                 *
                 *      什么是脏读什么是幻读？
                 *          无论是脏读还是幻读假设第一次读出了一条数据，第二次读出了两条
                 *          脏读和幻读唯一的区别就看事务是否提交(也就是说是否执行了commit操作)
                 *          如果执行了则就是幻读
                 *          如果没有执行就是脏读
                 *//*
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }*/
    /**
     * 执行登录操作
     * @param member
     * @param Member
     * @return
     */
    public String doLogin(Member member){
        try {
            Member member1 = super.selectOne(member);
            String token = member.getOpenId()+IDUtil.getUUID();

            if (null != member1){
                //数据库中有数据，登录成功
                member1.setToken(token);
                memberMapper.updateByPrimaryKey(member1);
                return token;
            }else {
                member.setToken(token);
                memberMapper.insert(member);
                return token;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	   /**
     * 获取用户信息
     * @param member
     * @return
     */

    public String newUser(Member member){

        if(null != member ){
            String token = member.getOpenId()+ IDUtil.getUUID();
            member.setToken(token);
            if ( memberMapper.insert(member) > 0){
                return token;
            }
            return null;
        }
        return null;
    }
    /**
     * @Author Zhang Wei
     * @Description
     *      获取用户积分、成长值和等级信息
     * @Param [memberId, shopId]
     * @Return com.huifangyuan.app.vo.MemberAndLevelVo
     * @Date 2019/11/28
     */
    public MemberAndLevelVo getMemberAndLevel(Long memberId, Long shopId){
        MemberAndLevelVo memberAndLevel = memberMapper.getMemberAndLevel(memberId, shopId);
        if(memberAndLevel != null){
            return memberAndLevel;
        }
        return null;
    }
    /**
     * @Author Zhang Wei
     * @Description
     *      修改用户积分，成长值和历史积分
     * @Param [memberAndLevelVo]
     * @Return java.lang.Boolean
     * @Date 2019/11/28
     */
    public Boolean updateMember(MemberAndLevelVo memberAndLevelVo){
        int updateResult = memberMapper.updateMember(memberAndLevelVo);
        if(updateResult>0){
            return true;
        }
        return false;
    }

}
