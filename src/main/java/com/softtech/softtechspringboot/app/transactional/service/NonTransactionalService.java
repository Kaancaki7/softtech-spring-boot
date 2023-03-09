package com.softtech.softtechspringboot.app.transactional.service;

import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.service.entityservice.CusCustomerEntityService;
import com.softtech.softtechspringboot.app.transactional.util.TransactionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NonTransactionalService {

    private final CusCustomerEntityService customerEntityService;
    private TransactionalService transactionalService;
    @Autowired
    public void setTransactionalService(@Lazy TransactionalService transactionalService) {
        this.transactionalService = transactionalService;
    }

    public void save(){

         CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts1");

        customerEntityService.save(cusCustomer);
    }

    public void saveN2T(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts4");

        customerEntityService.save(cusCustomer);

        transactionalService.save();
    }

    public void saveButError(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts7");

        customerEntityService.save(cusCustomer);

        throw new RuntimeException("error");
    }

}
