package com.huifangyuan.app.controller.userinfo;

import com.huifangyuan.app.base.BaseController;
import com.huifangyuan.app.base.ResultData;
import com.huifangyuan.app.domain.Member;
import com.huifangyuan.app.service.CouponService;
import com.huifangyuan.app.service.MemberInforService;
import com.huifangyuan.app.vo.MemberAllCouponVO;
import com.huifangyuan.app.vo.UsableCouponVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponController extends BaseController {

    @Autowired
    private MemberInforService memberInforService;
    @Autowired
    private CouponService couponService;


    /**
     * 获取领券中心用户所有的可见优惠券信息
     * @return
     **/
    @GetMapping("/getUsableCoupons")
    public ResultData<List<UsableCouponVO>> getAllUsableCoupons(@RequestParam("token") String token){

        Member m = memberInforService.getMemberInforToken(token);
        if (null != m){
            List<UsableCouponVO> allUsableCoupons = couponService.getAllUsableCoupons(m.getMemberLevelId());
            if (allUsableCoupons.size()>0){
               return super.operateSuccess(allUsableCoupons);
            }
           return super.operateSuccess("暂无可领取优惠券");
        }
       return super.operateFailed();
    }

    /**
     * 获取用户所有优惠券
     * @return
     **/
    @GetMapping("/getAllCouponsByMemberId")
    public ResultData<List> getAllCouponsByMemberId(@RequestParam("token") String token){

        Member m = memberInforService.getMemberInforToken(token);
        if (null != m){
            List<MemberAllCouponVO> allCouponsByMemberId = couponService.getAllCouponsByMemberId(m.getId());
            if (allCouponsByMemberId.size()>0){
                return super.operateSuccess(allCouponsByMemberId);
            }
            return super.operateSuccess("用户暂无优惠券");
        }
        return super.operateFailed();
    }

    /**
     * 获取用户所有可用优惠券
     * @return
     **/
    @GetMapping("/getUsableCouponsByMemberId")
    ResultData<List> getUsableCouponsByMemberId(@RequestParam("token") String token){

        Member m = memberInforService.getMemberInforToken(token);
        if (null != m){
            List<MemberAllCouponVO> usableCouponsByMemberId = couponService.getUsableCouponsByMemberId(m.getId());
            if (usableCouponsByMemberId.size()>0){
                return super.operateSuccess(usableCouponsByMemberId);
            }
            return super.operateSuccess("用户暂无可用优惠券");
        }
        return super.operateFailed();
    }

    /**
     * 获取用户所有不可用优惠券
     * @return
     **/
    @GetMapping("/getDisableCouponsByMemberId")
    public ResultData<List> getDisableCouponsByMemberId(@RequestParam("token") String token){

        Member m = memberInforService.getMemberInforToken(token);
        if (null != m){
            List<MemberAllCouponVO> disableCouponsByMemberId = couponService.getDisableCouponsByMemberId(m.getId());
            if (disableCouponsByMemberId.size()>0){
                return super.operateSuccess(disableCouponsByMemberId);
            }
            return super.operateSuccess("用户暂无可用优惠券");
        }
        return super.operateFailed();
    }

    /**
     * 获取用户在当前店铺所有可用优惠券
     * @return
     **/
    @GetMapping("/getUsableCouponsByMemberIdAndShopId")
    public ResultData<List> getUsableCouponsByMemberIdAndShopId(@RequestParam("shopId") Long shopId, @RequestParam("token") String token){

        Member m = memberInforService.getMemberInforToken(token);
        if (null != m){
            List<MemberAllCouponVO> usableCouponsByMemberIdAndShopId = couponService.getUsableCouponsByMemberIdAndShopId(m, shopId);
            if (null == usableCouponsByMemberIdAndShopId){
                return super.operateSuccess("无法获取商铺信息");
            }
            if (usableCouponsByMemberIdAndShopId.size()>0){
                return super.operateSuccess(usableCouponsByMemberIdAndShopId);
            }
            return super.operateSuccess("用户暂无可用优惠券");
        }
        return super.operateFailed();
    }

    /**
     * 领取优惠券
     * @return
     **/
    @GetMapping("/receiveCouponAffair")
    public ResultData receiveCouponAffair(@RequestParam("couponId") Long couponId, @RequestParam("token") String token){

        Member m = memberInforService.getMemberInforToken(token);
        if (null != m){
            Long l = couponService.checkCouponStatusFromAllCouponList(couponId, m.getId());
            if (null != l || "".equals(l)){
                String endTime = couponService.getCouponEndTimeByCouponId(couponId);
                if(null != endTime || !"".equals(endTime)){
                    try {
                        couponService.receiveCouponAffair(l, couponId, endTime, m);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return super.operateSuccess("操作失败");
                    }
                }
                return super.operateSuccess("添加成功");
            }
            return super.operateSuccess("优惠券已过期或已领取到达上限");
        }
        return super.operateFailed();
    }

    /**
     * 使用优惠券
     * @return
     **/
    @GetMapping("/useCouponAffair")
    public ResultData useCouponAffair(@RequestParam("couponHistoryId") Long couponHistoryId, @RequestParam("token") String token, @RequestParam("amount") Double amount){

        Member m = memberInforService.getMemberInforToken(token);
        if (null != m){
            int i = couponService.checkCouponStatusFromMemberListByCouponHistoryId(couponHistoryId, amount);
            if (i > 0) {
                if (couponService.useCouponAffair(couponHistoryId)){
                    return super.operateSuccess("OK");
                }
                return super.operateSuccess("操作失败");
            }
            return super.operateSuccess("优惠券不可用");
        }
        return super.operateFailed();
    }
}

