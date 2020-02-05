package com.tensquare.article.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @title: MyBatisPlusConfig
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  17:45
 */
public class MyBatisPlusConfig {
    /**
     * 分页插件
     * @return
     */
    @Bean
    private PaginationInterceptor createPaginationInterceptor(){
        return new PaginationInterceptor();
    }
}
