package com.softtech.softtechspringboot.app.transactional.service;

import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.service.entityservice.CusCustomerEntityService;
import com.softtech.softtechspringboot.app.transactional.util.TransactionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionalService {

    private final CusCustomerEntityService customerEntityService;
    public void save(){

        CusCustomer cusCustomer = TransactionalUtil.getDummyCusCustomer("ts2");

        customerEntityService.save(cusCustomer);
    }
}
