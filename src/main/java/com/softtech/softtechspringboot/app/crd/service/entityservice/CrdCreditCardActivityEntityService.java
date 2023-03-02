package com.softtech.softtechspringboot.app.crd.service.entityservice;

import com.softtech.softtechspringboot.app.crd.dao.CrdCreditCardActivityDao;
import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCardActivity;
import com.softtech.softtechspringboot.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CrdCreditCardActivityEntityService extends BaseEntityService<CrdCreditCardActivity, CrdCreditCardActivityDao> {

    public CrdCreditCardActivityEntityService(CrdCreditCardActivityDao dao) {
        super(dao);
    }
}