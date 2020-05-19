package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@Mapper
public interface AccountMapper {
    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);
}
