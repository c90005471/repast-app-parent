package com.huifangyuan.app.mapper;

import com.huifangyuan.app.domain.MemberCommentReplay;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberCommentReplayMapper extends Mapper<MemberCommentReplay> {
    List<MemberCommentReplay> selectCommentReplay(Long commentId);

}