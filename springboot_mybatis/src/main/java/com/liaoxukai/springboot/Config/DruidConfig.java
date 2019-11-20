package com.liaoxukai.springboot.Config;/*
 *@author:kai
 *@create:2019-11-2019/11/7-8:46
 */


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    //添加Druid的管理后台的Servlet和Web监控的Filter
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> map = new HashMap<>();
        //配置StatViewServlet父类ResourceServlet属性
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        map.put("allow","");            //允许访问
        bean.setInitParameters(map);           //设置属性进注册servlet
        return bean;
    }

    @Bean
    public FilterRegistrationBean WebStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String > map = new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        //设置拦截请求，这里设置拦截所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }


}
