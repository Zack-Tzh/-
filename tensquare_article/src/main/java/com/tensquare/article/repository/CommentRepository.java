package com.tensquare.article.repository;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @title: CommentRepository
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  23:00
 */
public interface CommentRepository extends MongoRepository<Comment,String> {

    /**
     * 根据文章id查询
     * @param articleId
     * @return
     */
    List<Comment> findByArticleid(String articleId);
}
