package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.Product;
import com.huifangyuan.app.vo.ProductVo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface ProductMapper extends Mapper<Product> {

    int updateProStock(Product product);

    int updateBackProStock(Product product);
    List<Product> getProductByShopId(Long shopId);
    List<Product> selectShopProduct(ProductVo productVo);
    List<Product> getIntegralProduct();

}