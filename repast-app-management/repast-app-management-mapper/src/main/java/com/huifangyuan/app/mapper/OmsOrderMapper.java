package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.OmsOrder;
import tk.mybatis.mapper.common.Mapper;

public interface OmsOrderMapper extends Mapper<OmsOrder> {
    int setOmsOrder(OmsOrder omsOrder);
}