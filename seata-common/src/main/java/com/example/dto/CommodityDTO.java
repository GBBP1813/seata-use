package com.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CommodityDTO  extends  BaseDTO{

    private Integer id;
    private String commodityCode;
    private String name;
    private Integer count;
}
