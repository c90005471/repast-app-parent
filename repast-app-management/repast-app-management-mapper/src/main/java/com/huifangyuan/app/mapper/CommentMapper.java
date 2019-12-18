package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.Comment;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface CommentMapper extends Mapper<Comment> {

    /**根据产品id获取所有产品评价*/
    List<Comment> getProductCommentById(Long productId);

    List<Comment> getShopCommentById(Long shopId);

}