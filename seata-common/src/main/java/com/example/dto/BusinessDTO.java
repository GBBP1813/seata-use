package com.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BusinessDTO  extends BaseDTO{

    private String userId;
    private String commodityCode;
    private String name;
    private Integer count;
    private Double amount;
}
