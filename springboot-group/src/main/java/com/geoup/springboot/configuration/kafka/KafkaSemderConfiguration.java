package com.geoup.springboot.configuration.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import com.google.common.io.Resources;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @author: lisy
 * @version: KafkaSemder , v0.1 2021年01月29日 14:11
 * @remark：KafkaSemder
 */
@Slf4j
public class KafkaSemderConfiguration {

    private static KafkaProducer<String , String> producer;
    private Gson gson = new GsonBuilder().create();

    static {
        try {
            InputStream props = Resources.getResource("producer.props").openStream();
            Properties properties = new Properties();
            properties.load(props);
            producer = new KafkaProducer<String, String>(properties);
        } catch (IOException e) {
            log.error("init kafka config error ");
        }
    }

    /**
     * 发送消息方法
     *
     * @param topic 主题
     * @param msg 消息体
     */
    public void sendMsg(String topic, String msg) {
        try {
            Future<RecordMetadata> record = producer.send(new ProducerRecord<String ,String>(topic, gson.toJson(msg)));
            record.get();
        } catch (Exception e) {
            log.error("sendErrorMessage = {}", gson.toJson(msg));
        }
    }
}
