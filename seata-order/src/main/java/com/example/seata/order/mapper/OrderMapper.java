package com.example.seata.order.mapper;

import com.example.seata.order.entity.OrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    void createOrder(@Param("order")OrderDO orderDO);
}
