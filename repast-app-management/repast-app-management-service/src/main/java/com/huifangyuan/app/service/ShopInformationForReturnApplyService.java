package com.huifangyuan.app.service;

import com.huifangyuan.app.base.BaseService;
import com.huifangyuan.app.domain.ShopInfo;
import com.huifangyuan.app.mapper.ShopInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author Administrator
 * @Date 2019/11/23
 * @Description
 **/
@Service
public class ShopInformationForReturnApplyService extends BaseService<ShopInfo> {

    @Autowired
    private ShopInformationMapper shopInformationMapper;

    @Override
    public Mapper<ShopInfo> getMapper() {
        return shopInformationMapper;
    }

    /**
     * @Author Administrator
     * @Description
     *        通过shopId获取商店名作为退货申请的收货人
     * @Date 2019/11/23
     * @Param [shopId]
     * @return java.lang.String
     **/
    public String getShopNameByShopId(Long shopId){
        return shopInformationMapper.selectShopNameByShopId(shopId);
    }
}
