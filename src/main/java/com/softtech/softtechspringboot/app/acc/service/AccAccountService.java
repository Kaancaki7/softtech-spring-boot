package com.softtech.softtechspringboot.app.acc.service;

import com.softtech.softtechspringboot.app.acc.converter.AccAccountMapper;
import com.softtech.softtechspringboot.app.acc.dto.AccAccountDto;
import com.softtech.softtechspringboot.app.acc.entity.AccAccount;
import com.softtech.softtechspringboot.app.acc.service.entityservice.AccAccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccAccountService {

    private final AccAccountEntityService accAccountEntityService;

    public List<AccAccountDto> findAll() {

        List<AccAccount> accAccountList = accAccountEntityService.findAll();

        List<AccAccountDto> accAccountDtoList = AccAccountMapper.INSTANCE.convertToAccountDtoList(accAccountList);

        return accAccountDtoList;
    }

    public AccAccountDto findById() {
        AccAccount accAccount = accAccountEntityService.getByIdWithControl(id);

        AccAccountDto accAccountDto = AccAccountMapper.INSTANCE.convertToAccountDto(accAccount);

        return accAccountDto;
    }
}
