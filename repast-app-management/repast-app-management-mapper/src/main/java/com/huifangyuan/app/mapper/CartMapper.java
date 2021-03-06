package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.Cart;
import com.huifangyuan.app.vo.CartInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface CartMapper extends Mapper<Cart> {

    Map<String,Object> selectByMidPid(Cart cart);

    int updateCartByIdBuyNum(Cart cart);

    int deleteCartById(Long id);

    List<Cart> selectByMidSid(Cart cart);

    int updateCartByShopId(Cart cart);

    CartInfo selectProductSkuByPid(Long pId);

    int deleteCartByShopId(Cart cart);

    Integer selectDeleteStatus(Long cartId);

    int insertReturnKey(Cart cart);

}