package com.example.seata.transcation.manage.controller;

import com.alibaba.fastjson.JSON;
import com.example.dto.BusinessDTO;
import com.example.response.DubboResponse;
import com.example.seata.transcation.manage.service.TransactionCoordinatorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/tmManager")
public class TmManager {

    @Autowired
    private TransactionCoordinatorService tmService;

    @PostMapping("/buy")
    public DubboResponse mockDistributedTransaction(@RequestBody BusinessDTO businessDTO,
                                                    @RequestParam(required = false) Boolean throwExp) {
     log.info("模拟分布式事务,businessDTO:{}, throwExp:{}", JSON.toJSONString(businessDTO), BooleanUtils.isTrue(throwExp));
     return tmService.mockDistributedTransaction(businessDTO, BooleanUtils.isTrue(throwExp));
    }
}
