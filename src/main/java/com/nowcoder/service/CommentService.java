package com.nowcoder.service;

import com.nowcoder.dao.CommentDAO;
import com.nowcoder.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhan on 2017/7/7.
 */
@Service
public class CommentService {
    private static final Logger logger = LoggerFactory.getLogger(QiniuService.class);

    @Autowired
    CommentDAO commentDAO;

    //获取某个实体所有评论
    public List<Comment> getCommentsByEntity(int entityId, int entityType) {
        return commentDAO.selectByEntity(entityId, entityType);
    }
    //添加评论
    public int addComment(Comment comment) {
        return commentDAO.addComment(comment);
    }
    //获取某个实体评论总数
    public int getCommentCount(int entityId, int entityType) {
        return commentDAO.getCommentCount(entityId, entityType);
    }
    
    public void deleteComment(int entityId, int entityType) {
        commentDAO.updateStatus(entityId, entityType, 1);
    }
}
