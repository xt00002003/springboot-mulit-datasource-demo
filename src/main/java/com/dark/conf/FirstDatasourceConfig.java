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
@MapperScan(basePackages =FirstDatasourceConfig.PACKAGE,sqlSessionFactoryRef = "firstSqlSessionFactory")
public class FirstDatasourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.dark.dao.first";
    static final String MAPPER_LOCATION = "classpath:mapper/first/*.xml";
    static final String CONFIG_LOCATION = "classpath:mybatis-config.xml";
    @Value("${first.datasource.url}")
    private String url;
    @Value("${first.datasource.username}")
    private String username;
    @Value("${first.datasource.password}")
    private String password;
    @Value("${first.datasource.driverClassName}")
    private String driverClassName;

    @Bean(name = "firstDataSource")
    @Primary
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "firstTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "firstSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("firstDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(FirstDatasourceConfig.MAPPER_LOCATION));
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(FirstDatasourceConfig.CONFIG_LOCATION));
        return sessionFactory.getObject();
    }

}
