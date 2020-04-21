package com.example.demo.service;

import com.example.dto.AccountDTO;
import com.example.response.DubboResponse;

/**
 * 账户服务
 * @author boomboompow
 */
public interface AccountService {

    DubboResponse decreaseAccountMoney(AccountDTO accountDTO);
}
