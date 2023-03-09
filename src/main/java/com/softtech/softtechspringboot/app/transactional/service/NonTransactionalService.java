package com.softtech.softtechspringboot.app.transactional.service;

import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.service.entityservice.CusCustomerEntityService;
import com.softtech.softtechspringboot.app.transactional.util.TransactionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NonTransactionalService {

    private final CusCustomerEntityService customerEntityService;
    public void save(){

         CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts1");

        customerEntityService.save(cusCustomer);
    }

}
