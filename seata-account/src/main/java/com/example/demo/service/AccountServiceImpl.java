package com.example.demo.service;

import com.example.demo.mapper.AccountMapper;
import com.example.dto.AccountDTO;
import com.example.enums.IError;
import com.example.enums.ResponseCodeEnum;
import com.example.response.DubboResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AccountServiceImpl  implements AccountService{

    @Resource
    private AccountMapper accountMapper;

    @Override
    public DubboResponse decreaseAccountMoney(AccountDTO accountDTO) {
        log.info("开始扣减账户余额：accountDTO:{}", accountDTO);
        int count = accountMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount());
        if (count > 0) {
            log.info("扣减账户余额成功");
            return DubboResponse.success(null);
        } else {
            log.error("扣减账户余额失败");
            return DubboResponse.fail(ResponseCodeEnum.FAIL);
        }


    }
}
