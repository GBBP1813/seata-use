package com.example.demo.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.service.AccountService;
import com.example.demo.tcc.TccAcountAction;
import com.example.dto.AccountDTO;
import com.example.dubbo.AccountServiceFacade;
import com.example.response.DubboResponse;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Slf4j
public class AccountServiceFacadeImpl implements AccountServiceFacade {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TccAcountAction tccAcountAction;

    @Override
    public DubboResponse decreaseAccount(AccountDTO accountDTO) {

        log.info("全局事务Id{}", RootContext.getXID());
        return accountService.decreaseAccountMoney(accountDTO);
    }

    @Override
    public DubboResponse<Boolean> callTccAction(String b, List<String> list) {
        log.info("全局事务Id{}", RootContext.getXID());
        boolean prepare = tccAcountAction.prepare(null, b, list);
        return DubboResponse.success(prepare);
    }
}
