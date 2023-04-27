package com.softtech.softtechspringboot.app.transactional.service;

import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.service.entityservice.CusCustomerEntityService;
import com.softtech.softtechspringboot.app.transactional.util.TransactionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
@RequiredArgsConstructor
public class NonTransactionalService {

    private final CusCustomerEntityService customerEntityService;
    private TransactionalService transactionalService;
    private final TransactionalService2 transactionalService2;
    private final NonTransactionalConstantService nonTransactionalConstantService;
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

    public void saveN2Mandatory(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts11-NT");

        customerEntityService.save(cusCustomer);

        transactionalService.saveMandatory();
    }

    public void saveN2Supports() {

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts14");

        customerEntityService.save(cusCustomer);

        transactionalService2.saveSupports();
    }

    public void doSomething(){

        for (int i = 0;i < 9999; i++){
            CusCustomer cusCustomer = nonTransactionalConstantService.findById(1L);
        }
    }

    public void saveNon2Never() {

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts19");

        customerEntityService.save(cusCustomer);

        nonTransactionalConstantService.saveNever();
    }
}
