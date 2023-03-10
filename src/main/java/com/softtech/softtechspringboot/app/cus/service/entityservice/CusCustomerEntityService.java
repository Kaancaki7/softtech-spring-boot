package com.softtech.softtechspringboot.app.cus.service.entityservice;

import com.softtech.softtechspringboot.app.cus.dao.CusCustomerDao;
import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.enums.CustomerErrorMessage;
import com.softtech.softtechspringboot.app.gen.exceptions.ItemNotFoundException;
import com.softtech.softtechspringboot.app.gen.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CusCustomerEntityService extends BaseEntityService<CusCustomer,CusCustomerDao> {



    public CusCustomerEntityService(CusCustomerDao dao) {
        super(dao);
    }
}
