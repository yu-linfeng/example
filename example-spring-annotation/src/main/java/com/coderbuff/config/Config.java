package com.coderbuff.config;

import com.coderbuff.bean.Demo;
import com.coderbuff.bean.InstanceA;
import com.coderbuff.bean.InstanceB;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by OKevin On 2019/8/27
 */
@PropertySource(value = {"classpath:/app.properties"})
@Configuration
@ComponentScan(value = "com.coderbuff")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class Config {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Demo demo() {
        return new Demo();
    }

    @Bean
    public InstanceA instanceA() {
        return new InstanceA();
    }

    @Bean
    public InstanceB instanceB() {
        return new InstanceB();
    }

    /**
     * @Profile("default")不指定环境时使用该配置
     * 可通过配置Run Config配置启动环境，-Dspring.profiles.active=test
     * 常结合maven使用
     */
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${test.db.url}") String url, @Value("${test.db.user}") String user, @Value("${test.db.password}") String password, @Value("${test.db.driverClass}") String driverClass) {
        System.out.println(String.format("数据源测试环境，url=%s, user=%s, password=%s, driverClass=%s", url, user, password, driverClass));
        return null;
    }

    /**
     * 同上
     */
    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.url}") String url, @Value("${db.user}") String user, @Value("${db.password}") String password, @Value("${db.driverClass}") String driverClass) {
        System.out.println(String.format("数据源生产环境，url=%s, user=%s, password=%s, driverClass=%s", url, user, password, driverClass));
        return null;
    }

    /**
     * 用于事务测试
     * @return 数据源
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("0000");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
