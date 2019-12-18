package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.MemberReceiveAddress;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberReceiveAddressMapper extends Mapper<MemberReceiveAddress> {

    /**
     * @author Seven Lee
     * @description
     *      通用会员id查询出所有的收获地址列表
     * @date 2019/11/21
     * @return java.util.List<com.huifangyuan.app.domain.MemberReceiveAddress>
     * @throws 
    **/
    List<MemberReceiveAddress> selectMemberReceiveAddrrss(Long memberId);

    Integer delSite(Long id );
}