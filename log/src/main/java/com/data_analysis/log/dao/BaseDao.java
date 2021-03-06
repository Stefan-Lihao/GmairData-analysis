package com.data_analysis.log.dao;


import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

/**
 * 该类用于管理持久层与数据库的连接mongo template, 所有的Dao需要继承此方法
 */
public class BaseDao {

    @Resource
    protected MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
