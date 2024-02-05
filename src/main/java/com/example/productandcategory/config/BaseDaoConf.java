package com.example.productandcategory.config;

import io.github.kiryu1223.baseDao.DataBase.DataBase;
import io.github.kiryu1223.baseDao.core.BaseDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BaseDaoConf
{
    @Bean
    public BaseDao getBaseDao(DataSource dataSource)
    {
        return new BaseDao(dataSource, DataBase.Type.Mysql);
    }
}
