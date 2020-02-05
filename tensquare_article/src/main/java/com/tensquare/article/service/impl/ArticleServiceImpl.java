package com.tensquare.article.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @title: ArticleServiceImpl
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  16:44
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有文章
     *
     * @return
     */
    @Override
    public List<Article> findAll() {
        List<Article> list = articleDao.selectList(null);
        return list;
    }

    /**
     * 根据ID查询文章
     *
     * @param articleId
     * @return
     */
    @Override
    public Article findById(String articleId) {

        Article article = articleDao.selectById(articleId);
        return article;
    }

    /**
     * 增加文章
     *
     * @param article
     */
    @Override
    public void save(Article article) {
        //使用分布式事务Id
        article.setId(idWorker.nextId() + "");
        //设置浏览、点赞、评论数的初始值。
        article.setVisits(0);
        article.setThumbup(0);
        article.setComment(0);
        Integer insert = articleDao.insert(article);

    }

    /**
     * 修改文章
     *
     * @param article
     */
    @Override
    public void updateById(Article article) {
//        Integer integer = articleDao.updateById(article);

        EntityWrapper<Article> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("id", article.getId());
        Integer update = articleDao.update(article, entityWrapper);
    }

    /**
     * 根据ID删除文章
     *
     * @param articleId
     */
    @Override
    public void deleteById(String articleId) {
//        Integer integer = articleDao.deleteById(articleId);
        EntityWrapper<Article> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("id", articleId);
        Integer delete = articleDao.delete(entityWrapper);
    }

    /**
     * 根据条件查询文章列表和分页
     *
     * @param map
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Article> findByPage(Map<String, Object> map, Integer page, Integer size) {
        //设置查询条件
        EntityWrapper<Article> wrapper = new EntityWrapper<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            wrapper.eq(map.get(key) != null, key, map.get(key));
        }
        //设置分页参数
        Page<Article> pageData = new Page<>(page, size);
        //执行查询
        List<Article> list = articleDao.selectPage(pageData, wrapper);
        pageData.setRecords(list);
        //返回
        return pageData;
    }
}
