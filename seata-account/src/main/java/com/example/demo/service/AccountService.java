package com.example.demo.service;

import com.example.dto.AccountDTO;
import com.example.response.DubboResponse;

/**
 * 账户服务
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
public interface AccountService {

    DubboResponse decreaseAccountMoney(AccountDTO accountDTO);
}
