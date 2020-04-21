package com.example.seata.transcation.manage.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubbo.AccountServiceFacade;
import com.example.seata.transcation.manage.tcc.TccLocalAction;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class TccService {

    @Autowired
    private TccLocalAction tccLocalAction;

    @Reference
    private AccountServiceFacade accountServiceFacade;


    @GlobalTransactional(name = "tcc-tx",timeoutMills = 300000)
    public void mockTcc(boolean throwEx) {
        log.info("开启全局事务，xid:{}", RootContext.getXID());
        boolean result1 = tccLocalAction.prepare(null, "param1");
        assert result1;

        boolean result2 = accountServiceFacade.callTccAction("param-b", Arrays.asList("param-c")).getData();
        assert  result2;

        if (throwEx) {
            throw  new RuntimeException("全局事务回滚");
        }

    }
}
