package com.softtech.softtechspringboot.app.transactional.service;

import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.service.entityservice.CusCustomerEntityService;
import com.softtech.softtechspringboot.app.transactional.util.TransactionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionalService {

    private final CusCustomerEntityService customerEntityService;
    private final NonTransactionalService nonTransactionalService;
    private final TransactionalService2 transactionalService2;
    public void save(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts2");

        customerEntityService.save(cusCustomer);
    }

    public void saveT2N(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts3");

        customerEntityService.save(cusCustomer);

        nonTransactionalService.save();
    }

    public void saveT2T(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts5");

        customerEntityService.save(cusCustomer);

        save();
    }

    public void saveButError(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts6");

        customerEntityService.save(cusCustomer);

        throw new RuntimeException("error");
    }

    public void saveT2RN(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts8-1");

        saveRN();

        customerEntityService.save(cusCustomer);
    }

    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveRN(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts8-2");

        customerEntityService.save(cusCustomer);
    }

    public void saveT2RNWithDifferentBean(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts9-1");

        transactionalService2.saveRN();

        customerEntityService.save(cusCustomer);
    }

    public void saveT2RNButError(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts10-1");

        customerEntityService.save(cusCustomer);

        for (int i = 0; i < 10; i++){
            try{
                transactionalService2.saveRN(i);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.MANDATORY)
    public void saveMandatory(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts12");

        customerEntityService.save(cusCustomer);
    }


    public void saveT2Mandatory(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts12");

        customerEntityService.save(cusCustomer);

        transactionalService2.saveMandatory();
    }

}
