package com.example.springbootgoodsdemo.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//@MapperScan(basePackages = "com.example.springbootgoodsdemo.mapper")
public class MybatisConfig {

//    @Value("${mysql.url}")
//    private String url;
//
//    @Value("${mysql.user}")
//    private String user;
//
//    @Value("${mysql.password}")
//    private String password;
////
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(url);
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
//        return dataSource;
//    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
////        //设置数据源
////        sqlSessionFactory.setDataSource(dataSource);
////        //设置别名
////        sqlSessionFactory.setTypeAliasesPackage("com.example.springbootgoodsdemo.entity");
////        //设置分页插件
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        sqlSessionFactory.setPlugins(pageInterceptor);
//        return sqlSessionFactory.getObject();
//    }

}
