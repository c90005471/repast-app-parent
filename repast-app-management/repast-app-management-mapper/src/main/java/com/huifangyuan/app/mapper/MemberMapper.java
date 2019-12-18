package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.Member;
import com.huifangyuan.app.vo.MemberAndLevelVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MemberMapper extends Mapper<Member> {

    MemberAndLevelVo getMemberAndLevel(@Param("memberId") Long memberId, @Param("shopId") Long shopId);

    int updateMember(MemberAndLevelVo memberAndLevelVo);
	    Member getMemberInforMemberId(Long memberId);

    List<Member> getMemberInforToken(String token);

    int updateMemberInfoMemberId(Member member);
}