package com.tensquare.article.service.impl;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.repository.CommentRepository;
import com.tensquare.article.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * @title: CommentServiceImpl
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  23:03
 */
@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询所有评论
     * @return
     */
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    /**
     * 根据id查询评论
     * @param commentId
     * @return
     */
    @Override
    public Comment findById(String commentId) {
        return commentRepository.findById(commentId).get();
    }

    /**
     * 新增评论
     * @param comment
     */
    @Override
    public void save(Comment comment) {
        comment.setId(idWorker.nextId()+"");
        comment.setThumbup(0);
        comment.setPublishdate(new Date());
        commentRepository.save(comment);
    }

    /**
     * 修改评论
     * @param comment
     */
    @Override
    public void updateById(Comment comment) {
        //id存在就修改，不存在就新增
        commentRepository.save(comment);
    }

    /**
     * 根据id删除
     * @param commentId
     */
    @Override
    public void deleteById(String commentId) {
        commentRepository.deleteById(commentId);
    }

    /**
     * 根据文章id查询评论
     * @param articleId
     * @return
     */
    @Override
    public List<Comment> findByArticleId(String articleId) {
        return commentRepository.findByArticleid(articleId);
    }

    /**
     * 评论点赞
     * @param commentId
     */
    @Override
    public void thumbup(String commentId) {
//        //查询评论
//        Comment comment = commentRepository.findById(commentId).get();
//        //点赞加1
//        comment.setThumbup(comment.getThumbup()+1);
//        //保存
//        commentRepository.save(comment);

        //使用mongo模版优化
        //封装查询条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(commentId));
        //封装修改类容
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"comment");
    }


}
