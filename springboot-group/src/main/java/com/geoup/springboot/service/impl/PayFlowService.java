package com.geoup.springboot.service.impl;

import com.geoup.springboot.entity.PayFlow;
import com.geoup.springboot.service.IPayFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lisy
 * @version: PayFlowService , v0.1 2021年01月29日 10:47
 * @remark：PayFlowService
 */
@Service
public class PayFlowService implements IPayFlowService {

    private static final String collectionName = "pay_flow";

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<PayFlow> getFlows(String userId) {
        List<Criteria> criterias = new ArrayList<Criteria>();
        if (userId != null) {
            Criteria userCri = Criteria.where("user_id").is(userId);
            criterias.add(userCri);
        }
        Query query = getQuery(criterias);
        List<PayFlow> payFlows = mongoTemplate.find(query, PayFlow.class, collectionName);
        return payFlows;
    }

    /**
     * 对查询条件进行封装
     * @param criteriaList
     * @return
     */
    private Query getQuery(List<Criteria> criteriaList) {
        Query query = null;
        Criteria[] criteriaArray = {};
        if (null != criteriaList && criteriaList.size() > 0) {
            criteriaArray = new Criteria[criteriaList.size()];
            for (int i = 0; i < criteriaList.size(); ++i) {
                criteriaArray[i] = criteriaList.get(i);
            }
            query = new Query();
            query.addCriteria(new Criteria().andOperator(criteriaArray));
        }
        return query;
    }
}
