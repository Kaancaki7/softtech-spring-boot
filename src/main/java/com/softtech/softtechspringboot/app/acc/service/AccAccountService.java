package com.softtech.softtechspringboot.app.acc.service;

import com.softtech.softtechspringboot.app.acc.converter.AccAccountMapper;
import com.softtech.softtechspringboot.app.acc.dto.AccAccountDto;
import com.softtech.softtechspringboot.app.acc.dto.AccAccountSaveRequestDto;
import com.softtech.softtechspringboot.app.acc.entity.AccAccount;
import com.softtech.softtechspringboot.app.acc.service.entityservice.AccAccountEntityService;
import com.softtech.softtechspringboot.app.gen.enums.GenStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccAccountService {

    private final AccAccountEntityService accAccountEntityService;

    public List<AccAccountDto> findAll() {

        List<AccAccount> accAccountList = accAccountEntityService.findAll();

        List<AccAccountDto> accAccountDtoList = AccAccountMapper.INSTANCE.convertToAccountDtoList(accAccountList);

        return accAccountDtoList;
    }

    public AccAccountDto findById(Long id) {
        AccAccount accAccount = accAccountEntityService.getByIdWithControl(id);

        AccAccountDto accAccountDto = AccAccountMapper.INSTANCE.convertToAccountDto(accAccount);

        return accAccountDto;
    }

    public AccAccountDto save(AccAccountSaveRequestDto accAccountSaveRequestDto) {

        AccAccount accAccount = AccAccountMapper.INSTANCE.convertToAccAccount(accAccountSaveRequestDto);

        accAccount = accAccountEntityService.save(accAccount);

        AccAccountDto accAccountDto = AccAccountMapper.INSTANCE.convertToAccountDto(accAccount);

        return accAccountDto;
    }

    public void cancel(Long accountId) {

        AccAccount accAccount = accAccountEntityService.getByIdWithControl(accountId);

        accAccount.setStatusType(GenStatusType.PASSIVE);

        accAccountEntityService.save(accAccount);
    }
}
