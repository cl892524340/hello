package config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration//表示该类是spring容器，对应applicationContext.xml文件
@MapperScan("com.dao")//扫描mapper文件，与dao接口关联
@ComponentScan({"com.service.impl","com.controller"})//注解扫描
public class AppConfig {
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo2");
        dataSource.setUsername("root");
        dataSource.setPassword("root;");
        return dataSource;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/views/");
        return viewResolver;
    }

    private PageInterceptor pageInterceptor(){
        PageInterceptor interceptor=new PageInterceptor();
        Properties properties=new Properties();
        properties.put("supportMethodsArguments","true");
        properties.put("reasonable","true");
        interceptor.setProperties(properties);
        return interceptor;
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver patternResolver=new PathMatchingResourcePatternResolver();
        Resource[] resources=patternResolver.getResources("classpath*:*Mapper.xml");
        sqlSessionFactoryBean.setPlugins(pageInterceptor());
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }
}
