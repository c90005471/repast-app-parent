package com.huifangyuan.app.controller.userinfo;

import com.huifangyuan.app.domain.Product;
import com.huifangyuan.app.domain.ProductCat;
import com.huifangyuan.app.service.ProductCatService;
import com.huifangyuan.app.service.ProductService;
import com.huifangyuan.app.service.ShopInfoService;
import com.huifangyuan.app.vo.ShopInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 11:00
 * @Description
 **/
//@RestController
public class ShopInfoControllerBak {

    @Autowired
    private ShopInfoService shopInfoService;
    @Autowired
    private ProductCatService productCatService;
    @Autowired
    private ProductService productService;

    /**
     * @author Seven Lee
     * @description
     *      通过主键查询店铺信息
     * @date 2019/11/21
     * @return java.lang.String
     * @throws 
    **/
    @GetMapping("/getById")
    public ShopInfoVo getShopById(@RequestParam("shopId") Long shopId) {
        return shopInfoService.getShopInfoByShopId(shopId);
    }

    /**
     * @author Seven Lee
     * @description
     *      通过店铺主键查询商品类目列表
     * @date 2019/11/21
     * @return com.huifangyuan.app.base.ResultData
     * @throws 
    **/
    @GetMapping("/getCatByShopId")
    public List<ProductCat> getCategoryByShopId(Long shopId) {
        ProductCat productCat = new ProductCat().setShopId(shopId);
        try {
            List<ProductCat> catList = productCatService.selectDomain(productCat);
            if(catList.size() > 0) {
                return catList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Seven Lee
     * @description
     *      通过店铺主键查询商品列表
     * @date 2019/11/21
     * @return java.util.List<com.huifangyuan.app.domain.Product>
     * @throws 
    **/
    @GetMapping("/getProductByShopId")
    public List<Product> getProductByShopId(Long shopId) {
        return productService.getProductByShopId(shopId);
    }
}
