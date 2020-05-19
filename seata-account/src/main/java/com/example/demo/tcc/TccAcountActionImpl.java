package com.example.demo.tcc;

import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@Slf4j
@Service
public class TccAcountActionImpl implements  TccAcountAction{

    @Override
    public boolean prepare(BusinessActionContext actionContext, String b, List list) {
        log.info("TccAcountAction prepare, xid:{}, b:{}, C:{}", actionContext.getXid(), list);
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        log.info("TccAcountAction commit, xid:{}, b:{}, C:{}", actionContext.getXid(), actionContext.getActionContext("b"), actionContext.getActionContext("c"));
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        log.info("TccAcountAction rollback, xid:{}",  actionContext.getXid());
        return true;
    }
}
