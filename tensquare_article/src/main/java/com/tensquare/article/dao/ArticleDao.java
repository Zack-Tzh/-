package com.tensquare.article.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.article.pojo.Article;
import org.springframework.stereotype.Repository;

/**
 * @title: ArticleDao
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  16:42
 */
@Repository
public interface ArticleDao extends BaseMapper<Article> {
}
