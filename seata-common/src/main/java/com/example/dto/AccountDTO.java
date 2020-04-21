package com.example.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class AccountDTO extends BaseDTO {

    private Integer id;
    private String userId;
    private Double amount;
}
