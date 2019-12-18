package com.huifangyuan.app.controller.product;

import com.huifangyuan.app.domain.ProductCat;
import com.huifangyuan.app.service.IntegralMallService;
import com.huifangyuan.app.service.MyRedisService;
import com.huifangyuan.app.service.ProductCatService;
import com.huifangyuan.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 11:00
 * @Description
 **/
@RestController
public class ProductCatController {

    @Autowired
    private ProductCatService productCatService;

    @Autowired
    private IntegralMallService integralMallService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private MyRedisService myRedisService;

    /**
     * 通过层级查询商品类型
     * @param
     * @return
     */
    @GetMapping("/getByLevel")
    public List<ProductCat> getCateByLevel(){
        return productCatService.getCateByLevel();
    };




}
