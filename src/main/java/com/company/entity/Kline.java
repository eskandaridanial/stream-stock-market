package com.company.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Kline {

    @JsonProperty("t")
    private Long klineStartTime;
    @JsonProperty("T")
    private Long klineCloseTime;
    @JsonProperty("s")
    private String symbol;
    @JsonProperty("i")
    private String interval;
    @JsonProperty("o")
    private String openPrice;
    @JsonProperty("c")
    private String closePrice;
    @JsonProperty("h")
    private String highPrice;
    @JsonProperty("l")
    private String lowPrice;
    @JsonProperty("x")
    private Boolean isClosed;

}






