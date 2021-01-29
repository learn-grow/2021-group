package com.geoup.springboot.service;

import com.geoup.springboot.entity.PayFlow;

import java.util.List;

/**
 * @author: lisy
 * @version: IPayFlowService , v0.1 2021年01月29日 10:46
 * @remark：IPayFlowService
 */
public interface IPayFlowService {

    List<PayFlow> getFlows(String userId);
}
