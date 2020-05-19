package com.example.demo.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.ToString;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@Data
@ToString
public class AccountDO  {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userId;
    private Double amount;

}
