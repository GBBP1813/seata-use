package com.example.seata.storage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StorageDO {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String commodityCode;
    private String name;
    private Integer count;
}
