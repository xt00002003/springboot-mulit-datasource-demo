package com.dark.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * springboot-mulit-datasource-demo
 * User: dark xue
 * Date: 2017/7/14
 * Time: 14:06
 * description:
 */
@Configuration
@MapperScan(basePackages = SecondDatasourceConfig.PACKAGE,sqlSessionFactoryRef = "SecondSqlSessionFactory")
public class SecondDatasourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.dark.dao.Second";
    static final String MAPPER_LOCATION = "classpath:mapper/Second/*.xml";
    @Value("${second.datasource.url}")
    private String url;
    @Value("${second.datasource.username}")
    private String username;
    @Value("${second.datasource.password}")
    private String password;
    @Value("${second.datasource.driverClassName}")
    private String driverClassName;

    @Bean(name = "SecondDataSource")
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "SecondTransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "SecondSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("SecondDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondDatasourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
