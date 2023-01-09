package com.softtech.softtechspringboot.app.acc.converter;

import com.softtech.softtechspringboot.app.acc.dto.*;
import com.softtech.softtechspringboot.app.acc.entity.AccAccount;
import com.softtech.softtechspringboot.app.acc.entity.AccAccountActivity;
import com.softtech.softtechspringboot.app.acc.entity.AccMoneyTransfer;
import com.softtech.softtechspringboot.app.acc.enums.AccAccountActivityType;
import com.softtech.softtechspringboot.app.acc.service.AccAccountActivityService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccAccountMapper {

    AccAccountMapper INSTANCE = Mappers.getMapper(AccAccountMapper.class);

    AccAccountDto convertToAccountDto(AccAccount accAccount);
    List<AccAccountDto> convertToAccountDtoList(List<AccAccount> accAccountList);

    AccAccount convertToAccAccount(AccAccountSaveRequestDto accAccountDto);

    AccMoneyTransfer convertToAccMoneyTransfer(AccMoneyTransferSaveRequestDto accMoneyTransferSaveRequestDto);

    AccMoneyTransferDto convertToAccMoneyTransferDto(AccMoneyTransfer accMoneyTransfer);

    AccAccountActivityDto convertToAccAccountActivityDto(AccAccountActivity accAccountActivity);


}
