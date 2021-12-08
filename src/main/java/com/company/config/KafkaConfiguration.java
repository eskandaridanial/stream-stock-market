package com.company.config;

import com.company.entity.Kline;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {
    private static final String BOOTSTRAP_SERVER = "localhost:9092";

    @Bean
    public ProducerFactory<String , Kline> producerFactory(){
        Map<String, Object> conf = new HashMap<>();
        conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG , BOOTSTRAP_SERVER);
        conf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG , StringSerializer.class);
        conf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG , JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(conf);
    }


    @Bean
    public KafkaTemplate<String , Kline> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
