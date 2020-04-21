package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);
}
