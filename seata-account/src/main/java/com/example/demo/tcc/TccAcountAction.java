package com.example.demo.tcc;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

import java.util.List;

@LocalTCC
public interface TccAcountAction {

    @TwoPhaseBusinessAction(name = "DubboTccActionTwo" , commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepare(BusinessActionContext actionContext,
                           @BusinessActionContextParameter(paramName = "b") String b,
                           @BusinessActionContextParameter(paramName = "c", index = 0) List list);

    public boolean commit(BusinessActionContext actionContext);


    public boolean rollback(BusinessActionContext actionContext);
}
