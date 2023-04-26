package com.softtech.softtechspringboot.app.transactional.service;

import com.softtech.softtechspringboot.app.cus.dao.CusCustomerDao;
import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NonTransactionalConstantService {


    private final CusCustomerDao customerDao;

    private Map<Long, CusCustomer> map = new LinkedHashMap<>();

    public CusCustomer findById(Long id){

        CusCustomer customer = map.get(id);
        if (customer != null){
            return customer;
        }

        Optional<CusCustomer> customerOptional = customerDao.findById(id);

        CusCustomer cusCustomer;
        if (customerOptional.isPresent()){
            cusCustomer = customerOptional.get();
        } else {
            throw new RuntimeException("error!");
        }

        map.put(cusCustomer.getId(), cusCustomer);

        return cusCustomer;
    }
}