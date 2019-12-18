package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.Coupon;
import com.huifangyuan.app.domain.CouponHistory;
import com.huifangyuan.app.domain.Member;
import com.huifangyuan.app.vo.MemberAllCouponVO;
import com.huifangyuan.app.vo.UsableCouponVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface CouponMapper extends Mapper<Coupon> {

    Long checkCouponStatusFromAllCouponList(Map m);

    int checkCouponStatusFromMemberListByCouponHistoryId(Map m);

    int useConponByCouponHistoryId(Long id);

    String getCouponEndTimeByCouponId(Long couponId);

    int collectCoupons(CouponHistory couponHistory);

    List<UsableCouponVO> getAllUsableCoupons(Long memberLevel);

    List<MemberAllCouponVO> getAllCouponsByMemberId(Long id);

    List<MemberAllCouponVO> getUsableCouponsByMemberId(Long id);

    List<MemberAllCouponVO> getDisableCouponsByMemberId(Long id);

    List<MemberAllCouponVO> getUsableCouponsByMemberIdAndShopId(Member m);

    boolean setAutoInvalid(Map<String, String> m);

    boolean removeAutoInvalid(Map<String, String> m);

}
