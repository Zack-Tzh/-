package com.tensquare.article.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.pojo.Article;

import java.util.List;
import java.util.Map;

/**
 * @title: ArticleService
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  16:43
 */
public interface ArticleService {
    /**
     * 查询所有文章
     * @return
     */
    List<Article> findAll();

    /**
     * 根据ID查询文章
     * @param articleId
     * @return
     */
    Article findById(String articleId);

    /**
     * 增加文章
     * @param article
     */
    void save(Article article);

    /**
     * 修改文章
     * @param article
     */
    void updateById(Article article);

    /**
     * 根据ID删除文章
     * @param articleId
     */
    void deleteById(String articleId);

    /**
     * 根据条件查询文章列表和分页
     * @param map
     * @param page
     * @param size
     * @return
     */
    Page<Article> findByPage(Map<String, Object> map, Integer page, Integer size);
}
