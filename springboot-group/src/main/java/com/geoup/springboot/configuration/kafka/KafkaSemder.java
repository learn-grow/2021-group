//package com.geoup.springboot.configuration.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
///**
// * @author: lisy
// * @version: KafkaSemder , v0.1 2021年01月29日 14:11
// * @remark：KafkaSemder
// */
//@Component
//public class KafkaSemder {
//
//
//    @Autowired
//    private KafkaTemplate<String ,String> kafkaTemplate;
//
//
//    public void sendMsg(String topic , String key ,String msg) {
//        kafkaTemplate.send(topic , key, msg);
//    }
//
//}
