package com.softtech.softtechspringboot.app.transactional.service;

import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.service.entityservice.CusCustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NonTransactionalService {

    private final CusCustomerEntityService customerEntityService;
    public void save(){

        CusCustomer cusCustomer = new CusCustomer();
        cusCustomer.setName("test");
        cusCustomer.setSurName("test");
        cusCustomer.setIdentityNo(12312312312L);
        cusCustomer.setPassword("123");

        customerEntityService.save(cusCustomer);
    }
}
