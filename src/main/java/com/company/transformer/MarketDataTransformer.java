package com.company.transformer;

import com.company.entity.Kline;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class MarketDataTransformer {

    private final ObjectMapper objectMapper;

    public MarketDataTransformer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Transformer
    public Kline transform(Map<String , Object> candle) throws JsonProcessingException {
        Map<String , Object> klineData = (Map<String, Object>) candle.get("k");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Kline kline = objectMapper.readValue(new JSONObject(klineData).toString() , Kline.class);

        log.info("Kline successfully mapped [INTERVAL : " + kline.getI() + "]");

        return kline;
    }
}
