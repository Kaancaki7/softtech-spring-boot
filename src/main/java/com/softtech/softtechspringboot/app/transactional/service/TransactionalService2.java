package com.softtech.softtechspringboot.app.transactional.service;

import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.service.entityservice.CusCustomerEntityService;
import com.softtech.softtechspringboot.app.transactional.util.TransactionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionalService2 {

    private final CusCustomerEntityService customerEntityService;

    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveRN(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts9-2");

        customerEntityService.save(cusCustomer);
    }

    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveRN(int i){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts10-" + i);

        if (i == 7){
            throw new RuntimeException("error!");
        }

        customerEntityService.save(cusCustomer);
    }

    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.MANDATORY)
    public void saveMandatory(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts12");

        customerEntityService.save(cusCustomer);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveSupports() {

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts13");

        customerEntityService.save(cusCustomer);

    }

    @Transactional(propagation = Propagation.NESTED)
    public void saveNested() {

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts16");

        customerEntityService.save(cusCustomer);
    }
}
