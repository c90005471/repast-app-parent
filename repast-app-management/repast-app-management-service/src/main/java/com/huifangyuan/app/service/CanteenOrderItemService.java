package com.huifangyuan.app.service;

import com.huifangyuan.app.base.BaseService;
import com.huifangyuan.app.domain.OrderItem;
import com.huifangyuan.app.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author SGZ
 * @Date Create in 2019/11/23 20:23
 * @Description
 **/
@Service
public class CanteenOrderItemService extends BaseService<OrderItem> {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public Mapper<OrderItem> getMapper() {
        return orderItemMapper;
    }
    /**
     * @Author SGZ
     * @Description
     *      根据订单商品属性查询对应订单商品信息
     * @Param [orderItem]
     * @Return java.util.List<com.huifangyuan.app.domain.OrderItem>
     * @Date 2019/11/23
     */
    public List<OrderItem> getProductByOrderId(OrderItem orderItem){
        try {
            List<OrderItem> orderItems = super.selectDomain(orderItem);
            if(orderItems.size()>0){
                return orderItems;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
