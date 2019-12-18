package com.huifangyuan.app.service;

import com.huifangyuan.app.base.BaseService;
import com.huifangyuan.app.base.ResultData;
import com.huifangyuan.app.domain.Collect;
import com.huifangyuan.app.domain.Member;
import com.huifangyuan.app.domain.OmsOrder;
import com.huifangyuan.app.domain.PmsProduct;
import com.huifangyuan.app.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

import static com.huifangyuan.app.staticstatus.StaticProperties.*;


@Service
public class
CollectService extends BaseService<Collect> {

    @Autowired
    private CollectMapper collectMapper;
    ResultData resultData = new ResultData();
    @Override
    public Mapper<Collect> getMapper() {
        return collectMapper;
    }

    private Collect collect = new Collect();

    /**
     * 执行收藏单品操作 根据用户id和商品id
     * @param
     * @param productId
     * @return
     */
    public ResultData toCollect(Long productId, String token){

        //判断商品当前状态  i=1 上架
        int i = collectMapper.selectProductStatusById(productId);
        if (i == 1){
            Member member = collectMapper.selectMemberByToken(token);
            if (null !=member ){
                collect.setMemberId(member.getId());
                collect.setProductId(productId);
                //查询是否已经收藏该商品
                Collect collect1 = collectMapper.selectIfCollectProduct(this.collect);
                if (null != collect1){
                    //查询数据库有数据  说明该用户已经收藏该商品，再次点击时，应该执行取消收藏操作
                    //取消收藏 --
                    Integer result = collectMapper.deleteCollectProductByMemberId(collect);
                    resultData.setCode(CANCEL);
                    resultData.setMsg("取消收藏");
                    return resultData;
                }else {
                    int aaa = collectMapper.insertCollectProductByMemberId(this.collect);
                    resultData.setCode(SUCCESS);
                    resultData.setMsg("商品添加收藏成功");
                    return resultData;
                }
            }
            resultData.setCode(NOTLOGIN);
            resultData.setMsg("没有登录");
            return resultData;
         }else {
            resultData.setCode(SOLDOUT);
            resultData.setMsg("商品已下架");
            return resultData;
         }


    }

    /**
     * 执行收藏用户订单操作
     * @param
     * @param orderId
     * @return
     */
    public ResultData toCollectOrder(Long orderId, String token){
        Member member = collectMapper.selectMemberByToken(token);
        if (null !=member ){
            collect.setMemberId(member.getId());
            collect.setOrderId(orderId);
            //去数据库中查询该用户是否收藏该订单
            Collect collect1 = collectMapper.selectIfCollectOrder(collect);
            if (null != collect1){
                //收藏表中有该订单时，点击取消收藏该订单
                Integer integer = collectMapper.deleteCollectOrderByMemberId(collect);
                resultData.setCode(CANCEL);
                resultData.setMsg("取消收藏");
                return resultData;
            }else {
                Integer integer = collectMapper.insertCollectOrderByMemberId(collect);
                resultData.setCode(SUCCESS);
                resultData.setMsg("商品添加收藏成功");
                return resultData;
            }
        }
        resultData.setCode(NOTLOGIN);
        resultData.setMsg("没有登录");
        return resultData;
    }
    /**
     * 查询当前用户的所有单品收藏
     * @param
     * @param token
     * @return
     */
    public ResultData selectAllCollectProduct(String token){
        Member member = collectMapper.selectMemberByToken(token);
        if (null !=member){
            List<PmsProduct> pmsProductList = collectMapper.selectAllCollectProductByMemberId(member.getId());
            resultData.setCode(WIN);
            resultData.setMsg(null);
            resultData.setData(pmsProductList);
            return resultData;
        }else {
            resultData.setCode(NOTLOGIN);
            resultData.setMsg("没有登录");
            return resultData;
        }
    }

    /**
     * 查询当前用户的所有订单收藏
     * @return
     */
    public ResultData selectAllCollectOrder(String token){
        Member member = collectMapper.selectMemberByToken(token);
        if (null !=member){
            List<OmsOrder> omsOrderList = collectMapper.selectAllCollectOrderByMemberId(member.getId());
            resultData.setCode(WIN);
            resultData.setData(omsOrderList);
            return resultData;
        }
        resultData.setCode(NOTLOGIN);
        resultData.setMsg("没有登录");
        return resultData;
    }
    /**
     * 查询该用户的所有收藏总数
     * @param token
     * @return
     */

    public ResultData selectAllCollect(String token){
        Member member = collectMapper.selectMemberByToken(token);
        if (null !=member){
            Map<String, Object> collectCount = collectMapper.selectAllCollectCountByMember(member.getId());
            resultData.setCode(WIN);
            resultData.setData(collectCount);
            resultData.setMsg(null);
            return resultData;
        }
        resultData.setCode(NOTLOGIN);
        resultData.setMsg("没有登录");
        return resultData;
    }

}


