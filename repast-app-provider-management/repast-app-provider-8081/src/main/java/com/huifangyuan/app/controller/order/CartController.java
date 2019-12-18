package com.huifangyuan.app.controller.order;

import com.huifangyuan.app.domain.Cart;
import com.huifangyuan.app.service.CartService;
import com.huifangyuan.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/addCart")
    public Boolean addCartByProductId(@RequestBody Map<String,Object> data){
        return cartService.addCart(data,memberService);
    }
    @PostMapping("/selectCart")
    public List<Cart> selectCart(@RequestBody Map<String,Object> data){

        return cartService.selectCart(data,memberService);
    }

     @PostMapping("/deleteCart")
    public Boolean deleteCartByShopId(@RequestBody Map<String,Object> data){

        return cartService.deleteCartByShopId(data,memberService);
    }

}
