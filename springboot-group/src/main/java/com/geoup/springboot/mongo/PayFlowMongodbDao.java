package com.geoup.springboot.mongo;

import com.geoup.springboot.entity.PayFlow;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author: lisy
 * @version: PayFlowMongodbDao , v0.1 2021年01月29日 10:39
 * @remark：PayFlowMongodbDao
 */
public interface PayFlowMongodbDao extends MongoRepository<PayFlow , Long> {

    /**
     * 根据用户id查找
     * @param userId
     * @return
     */
    public List<PayFlow> findByUserId(String userId);
}
