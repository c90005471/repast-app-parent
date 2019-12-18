package com.huifangyuan.app.service;

import com.huifangyuan.app.base.BaseService;
import com.huifangyuan.app.domain.OmsOrder;
import com.huifangyuan.app.mapper.OmsOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Company AAA软件教育
 * @Author Lee
 * @Date Create in 2019/11/28 09:09
 * @Description
 **/
@Service
public class OrderInfoService extends  BaseService<OmsOrder> {
    @Autowired
    private  OmsOrderMapper omsOrderMapper;
    @Override
    public Mapper<OmsOrder> getMapper() {
        return omsOrderMapper;
    }
    /**
     * @Author Lee
     * @Description
     *   根据订单编号查询订单的详细数据
     * @Param  * @param OrderSn
     * @Return com.huifangyuan.app.domain.OmsOrder
     * @Date 2019/11/28
     */
    public OmsOrder selectOrderInfo(String OrderSn){
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setOrderSn(OrderSn);

        try {
            OmsOrder   omsOrder1 = super.selectOne(omsOrder);
            super.selectDomain(omsOrder);
            if(omsOrder1 !=  null){
                return   omsOrder1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }


}
