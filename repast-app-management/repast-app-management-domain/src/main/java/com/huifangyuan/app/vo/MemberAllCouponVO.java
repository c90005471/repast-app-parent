package com.huifangyuan.app.vo;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class MemberAllCouponVO extends UsableCouponVO {

    /**
     * 订单编号
     */
    private Long couponHistoryId;

    /**
     * 使用状态：0->未使用；1->已使用；2->已过期
     */
    @Column(name = "use_status")
    private int useStatus;

    /**
     * 订单编号
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单号码
     */
    @Column(name = "order_sn")
    private String orderSn;


}
