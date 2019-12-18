package com.huifangyuan.app.mapper;

import com.huifangyuan.app.vo.CartItemAndOrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartItemAndOrderVoMapper {
    List<CartItemAndOrderVO>selctCartItemAndOrder(@Param("memberId") Long memberId,@Param("shopId") Long shopId);


}
