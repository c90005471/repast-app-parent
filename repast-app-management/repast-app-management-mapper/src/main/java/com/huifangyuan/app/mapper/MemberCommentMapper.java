package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.Member;
import com.huifangyuan.app.domain.MemberComment;
import com.huifangyuan.app.vo.CommentProVo;
import com.huifangyuan.app.vo.MemberCommentVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberCommentMapper extends Mapper<MemberComment> {

    /**
     * 通过会员id查询评价信息
     * @param memberId
     * @return
     */
    List<MemberCommentVo> selectMemberComment(Long memberId);

    /**
     * 通过订单id，查询与订单有关的商品id,名称，属性名
     * @param orderId
     * @return
     */
    List<CommentProVo> selectProComment(Long orderId);

    /**
     * 通过评价主键id
     * @param id
     * @return
     */
    int updateCommentStatus(Long id);

    /**
     * 通过token查询当前用户信息
     * @param token
     * @return
     */
    Member getMemberByToken(String token);
}