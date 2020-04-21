package com.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class OrderDTO  extends  BaseDTO{

    private String orderNo;
    private String userId;
    private String commodityCode;
    private Integer orderCount;
    private Double orderAmount;
}
