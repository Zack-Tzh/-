package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: CommentController
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  23:04
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 评论点赞
     * @param commentId
     * @return
     */
    @PutMapping("/thumbup/{commentId}")
    public Result thumbup(@PathVariable("commentId")String commentId){
        commentService.thumbup(commentId);
        return new Result(true,StatusCode.OK,"点赞成功!");
    }

    /**
     * 根据文章id查询评论
     * @param articleId
     * @return
     */
    @GetMapping("/article/{articleId}")
    public Result findByArticleId(@PathVariable("articleId")String articleId){
        List<Comment> list = commentService.findByArticleId(articleId);
        return new Result(true,StatusCode.OK,"查询成功！",list);
    }

    /**
     * 查询所有评论
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Comment> list = commentService.findAll();
        return new Result(true, StatusCode.OK,"查询成功！",list);
    }

    /**
     * 根据id查询评论
     * @return
     */
    @GetMapping("/{commentId}")
    public Result findAll(@PathVariable("commentId")String commentId){
        Comment comment = commentService.findById(commentId);
        return new Result(true, StatusCode.OK,"查询成功！",comment);
    }

    /**
     * 新增评论
     * @param comment
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Comment comment){
        commentService.save(comment);
        return new Result(true,StatusCode.OK,"新增成功！");
    }

    /**
     * 修改评论
     * @param commentId
     * @param comment
     * @return
     */
    @PutMapping("/{commentId}")
    public Result updateById(@PathVariable("commentId")String commentId,@RequestBody Comment comment){
        comment.setId(commentId);
        commentService.updateById(comment);
        return new Result(true,StatusCode.OK,"修改成功！");
    }

    /**
     * 根据id删除
     * @param commentId
     * @return
     */
    @DeleteMapping("/{commentId}")
    public Result deleteById(@PathVariable("commentId")String commentId){
        commentService.deleteById(commentId);
        return new Result(true,StatusCode.OK,"删除成功！");
    }

}
