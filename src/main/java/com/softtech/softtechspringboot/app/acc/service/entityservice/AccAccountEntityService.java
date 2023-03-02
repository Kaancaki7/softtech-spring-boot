package com.softtech.softtechspringboot.app.acc.service.entityservice;

import com.softtech.softtechspringboot.app.acc.dao.AccAccountDao;
import com.softtech.softtechspringboot.app.acc.entity.AccAccount;
import com.softtech.softtechspringboot.app.cus.enums.CustomerErrorMessage;
import com.softtech.softtechspringboot.app.gen.enums.GenStatusType;
import com.softtech.softtechspringboot.app.gen.exceptions.ItemNotFoundException;
import com.softtech.softtechspringboot.app.gen.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccAccountEntityService extends BaseEntityService<AccAccount, AccAccountDao> {

    public AccAccountEntityService(AccAccountDao dao) {
        super(dao);
    }

    public List<AccAccount> findAllByStatusType(GenStatusType statusType){
        return getDao().findAllByStatusType(statusType);
    }
}
