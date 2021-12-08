package com.company.transformer;

import com.company.entity.Kline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Transformer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaPublisherTransformer {
    // your own topic name
    private static final String TOPIC = "market-stream-data";

    private final KafkaTemplate<String , Kline> template;

    public KafkaPublisherTransformer(KafkaTemplate<String, Kline> template) {
        this.template = template;
    }

    @Transformer
    public Object transform(Kline kline){
        template.send(TOPIC , kline);

        log.info("Published into kafka");

        return "";
    }
}
