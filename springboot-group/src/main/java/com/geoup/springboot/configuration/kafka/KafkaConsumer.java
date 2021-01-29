//package com.geoup.springboot.configuration.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.annotation.KafkaListeners;
//
///**
// * @author: lisy
// * @version: KafkaConsumer , v0.1 2021年01月29日 14:16
// * @remark：KafkaConsumer
// */
//@Configuration
//public class KafkaConsumer {
//
//
//    @KafkaListeners(value = {@KafkaListener(topicPattern = "^topic.*$")})
//    public String listenner(ConsumerRecord<? , ?> cr) {
//        return cr.value() + "";
//    }
//}
