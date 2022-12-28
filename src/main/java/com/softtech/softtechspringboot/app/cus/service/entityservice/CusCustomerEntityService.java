package com.softtech.softtechspringboot.app.cus.service.entityservice;

import com.softtech.softtechspringboot.app.cus.dao.CusCustomerDao;
import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CusCustomerEntityService {

    private final CusCustomerDao cusCustomerDao;

    public List<CusCustomer> findAll() {
        return cusCustomerDao.findAll();
    }

    public Optional<CusCustomer> findById(Long id) {
        return cusCustomerDao.findById(id);
    }

    public CusCustomer save(CusCustomer cusCustomer){
        return cusCustomerDao.save(cusCustomer);
    }

    public void delete(CusCustomer cusCustomer){
        cusCustomerDao.delete(cusCustomer);
    }
}
