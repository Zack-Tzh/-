package com.tensquare.article.service;

import com.tensquare.article.pojo.Comment;

import java.util.List;

/**
 * @title: CommentService
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  23:02
 */
public interface CommentService {
    /**
     * 查询所有评论
     * @return
     */
    List<Comment> findAll();

    /**
     * 根据id查询评论
     * @param commentId
     * @return
     */
    Comment findById(String commentId);

    /**
     * 新增评论
     * @param comment
     */
    void save(Comment comment);

    /**
     * 修改评论
     * @param comment
     */
    void updateById(Comment comment);

    /**
     * 根据id删除
     * @param commentId
     */
    void deleteById(String commentId);

    /**
     * 根据文章id查询评论
     * @param articleId
     * @return
     */
    List<Comment> findByArticleId(String articleId);

    /**
     * 评论点赞
     * @param commentId
     */
    void thumbup(String commentId);
}
