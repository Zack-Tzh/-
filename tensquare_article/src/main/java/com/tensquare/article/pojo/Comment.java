package com.tensquare.article.pojo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @title: Comment
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  22:54
 */
public class Comment implements Serializable {

    @Id
    private String id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;
    private Integer thumbup;

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", articleid='" + articleid + '\'' +
                ", content='" + content + '\'' +
                ", userid='" + userid + '\'' +
                ", parentid='" + parentid + '\'' +
                ", publishdate=" + publishdate +
                ", thumbup='" + thumbup + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getThumbup() {
        return thumbup;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }
}
