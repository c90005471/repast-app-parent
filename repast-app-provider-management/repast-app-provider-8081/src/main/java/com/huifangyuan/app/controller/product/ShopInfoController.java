package com.huifangyuan.app.controller.product;

import com.huifangyuan.app.cutom.ShopInfoCutom;
import com.huifangyuan.app.domain.Comment;
import com.huifangyuan.app.domain.Product;
import com.huifangyuan.app.service.*;
import com.huifangyuan.app.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 11:00
 * @Description
 **/
@RestController
public class ShopInfoController {

    @Autowired
    ShopInfoService shopInfoService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ShopCommentService shopCommentService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private MyRedisService myRedisService;



    /**
     * 通过店铺 关键字搜素商品列表
     * @param productVo
     * @return
     */
    @PostMapping("/selectShopProduct")
    public List<Product> selectShopProduct(@RequestBody ProductVo productVo){
        return productService.selectShopProduct(productVo);
    }

    /**
     * 进入积分商城，查询所有积分商品列表
     */
    @GetMapping("/selectIntegralProduct")
    public List<Product> selectIntegralProduct(){
        return productService.getIntegralProduct();
    }

    /**
     * 通过店铺id查询出店铺评价
     * @param shopId
     * @return
     */
    @GetMapping("/getShopCommentById")
    public List<Comment> getShopCommentById(@RequestParam("shopId") Long shopId){
        Comment commentVo = new Comment().setShopId(shopId);
        try {
            List<Comment> shopCommentById = shopCommentService.getShopCommentById(shopId);
            if (shopCommentById.size() > 0){
                    return shopCommentById;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * @description
     *      通过店铺主键查询商品列表
     * @param
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.Product>
     * @throws
     **/
    @GetMapping("/getProductByShopId")
    public List<Product> getProductByShopId(@RequestParam("shopId") Long shopId) {
        return productService.getProductByShopId(shopId);
    }

    @GetMapping ("/getShopAllInfoLAOYANG")
    ShopInfoCutom getShopAllInfoLAOYANG(@RequestParam("shopId") Long ShopId){
        return shopInfoService.getShopAllInfoLAOYANG(ShopId,redisService,myRedisService);//暂时不用redis，后面优化redis中存入的数据格式
    }
}


