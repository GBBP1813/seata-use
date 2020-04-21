package com.example.seata.storage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {
    int decreaseStorage(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
