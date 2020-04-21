package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.AccountService;
import com.example.dto.AccountDTO;
import com.example.response.DubboResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/duct")
    DubboResponse ductAccountMoney(@RequestBody AccountDTO accountDTO){

        log.info("扣减账户余额，accountDTO:{}", JSON.toJSONString(accountDTO));
        return accountService.decreaseAccountMoney(accountDTO);

    }
}
