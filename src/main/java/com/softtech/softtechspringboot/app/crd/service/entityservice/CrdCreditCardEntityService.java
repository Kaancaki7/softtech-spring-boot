package com.softtech.softtechspringboot.app.crd.service.entityservice;

import com.softtech.softtechspringboot.app.crd.dao.CrdCreditCardDao;
import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCard;
import com.softtech.softtechspringboot.app.gen.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CrdCreditCardEntityService extends BaseEntityService<CrdCreditCard, CrdCreditCardDao> {

    public CrdCreditCardEntityService(CrdCreditCardDao dao) {
        super(dao);
    }
}
