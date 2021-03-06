package com.huifangyuan.app.service;

import com.huifangyuan.app.base.BaseService;
import com.huifangyuan.app.domain.Comment;
import com.huifangyuan.app.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Company AAA软件教育
 * @Author Zhang Wei
 * @Date Create in 2019/11/23 19:32
 * @Description
 **/
@Service
public class CommentService extends BaseService<Comment> {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Mapper<Comment> getMapper() {
        return commentMapper;
    }
    /**
     * @Author Zhang Wei
     * @Description
     *      根据shopId，orderId，orderId查询评论状态
     * @Param [shopId]
     * @Return com.huifangyuan.app.domain.Comment
     * @Date 2019/11/23
     */
    public Comment selectComment(Comment comment){
        try {
            Comment comment1 = super.selectOne(comment);
            if(comment1 != null){
                return comment1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author Zhang Wei
     * @Description
     *      添加新评论
     * @Param [comment]
     * @Return java.lang.Boolean
     * @Date 2019/11/24
     */
    public Boolean addComment(Comment comment){
        try {
            Integer saveResult = super.save(comment);
            if(saveResult>0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
