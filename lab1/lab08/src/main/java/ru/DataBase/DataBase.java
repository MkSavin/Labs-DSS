package ru.DataBase;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DataBase {

    public static Connection C() throws SQLException {
        return dataSource().getConnection();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public static DataSource dataSource() throws SQLException {
        // return DataSourceBuilder.create().build();

        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriver(new com.mysql.cj.jdbc.Driver());
        ds.setUrl("jdbc:mysql://localhost:3307/zhaba08?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("");

        return ds;
    }

}
