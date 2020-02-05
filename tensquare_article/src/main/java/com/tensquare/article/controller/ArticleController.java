package com.tensquare.article.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @title: ArticleController
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  16:46
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * GET /article 文章全部列表
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Article> list = articleService.findAll();
        return new Result(true, StatusCode.OK,"查询成功！",list);
    }

    /**
     * GET /article/{articleId} 根据ID查询文章
     * @return
     */
    @GetMapping("/{articleId}")
    public Result findById(@PathVariable("articleId")String articleId){
        Article article = articleService.findById(articleId);
        return new Result(true,StatusCode.OK,"查询成功！",article);
    }

    /**
     * POST  /article  增加文章
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Article article){
        articleService.save(article);
        return new Result(true,StatusCode.OK,"新增成功！");
    }

    /**
     * PUT  /article/{articleId}  修改文章
     * @return
     */
    @PutMapping("/{articleId}")
    public Result updateById(@PathVariable("articleId")String articleId,@RequestBody Article article){
        article.setId(articleId);
        articleService.updateById(article);
        return new Result(true,StatusCode.OK,"修改成功！");
    }

    /**
     * DELETE  /article/{articleId}  根据ID删除文章
     * @return
     */
    @DeleteMapping("/{articleId}")
    public Result deleteById(@PathVariable("articleId")String articleId){
        articleService.deleteById(articleId);
        return new Result(true,StatusCode.OK,"删除成功！");
    }

    /**
     * POST  /article/search/{page}/{size}  根据条件查询文章列表和分页
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public Result search(@PathVariable("page")Integer page,
                         @PathVariable("size")Integer size,
                         @RequestBody Map<String,Object> map){

        Page<Article> pageData = articleService.findByPage(map,page,size);

        PageResult<Article> pageResult = new PageResult<>(
          pageData.getTotal(),pageData.getRecords()
        );

        return new Result(true,StatusCode.OK,"查询成功！",pageResult);
    }



}
