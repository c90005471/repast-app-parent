package com.huifangyuan.app.vo;

import com.huifangyuan.app.domain.MemberComment;
import com.huifangyuan.app.domain.MemberCommentReplay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author Whc
 * @Date 2019/11/29 19:26
 * @Description
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MemberCommentVo extends MemberComment {

    private List<CommentProVo> memberCommentVos;

    private List<MemberCommentReplay> commentReplays;

}
