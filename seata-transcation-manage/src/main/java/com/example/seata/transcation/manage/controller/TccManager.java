package com.example.seata.transcation.manage.controller;


import com.example.dto.BusinessDTO;
import com.example.seata.transcation.manage.service.TccService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@RestController
@RequestMapping("/tcc")
@Slf4j
public class TccManager {

    @Autowired
    private TccService tccService;


    @PostMapping("/bug")
    public void testTcc(@RequestParam(required = false) Boolean throwExp) {
        log.info("模拟Tcc");
        tccService.mockTcc(BooleanUtils.isTrue(throwExp));

    }
}
