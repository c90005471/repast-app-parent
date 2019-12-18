package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.OmsOrderItem;
import tk.mybatis.mapper.common.Mapper;

public interface OmsOrderItemMapper extends Mapper<OmsOrderItem> {
    int setOrderItem(OmsOrderItem orderItem);
}