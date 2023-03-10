package com.softtech.softtechspringboot.app.crd.converter;

import com.softtech.softtechspringboot.app.crd.dto.CrdCreditCardActivityDto;
import com.softtech.softtechspringboot.app.crd.dto.CrdCreditCardResponseDto;
import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCard;
import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCardActivity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CrdCreditCardMapper {

    CrdCreditCardMapper INSTANCE = Mappers.getMapper(CrdCreditCardMapper.class);

    CrdCreditCardResponseDto convertToCrdCreditCardResponseDto(CrdCreditCard crdCreditCard);

    List<CrdCreditCardResponseDto> convertToCrdCreditCardResponseDtoList(List<CrdCreditCard> creditCardList);
}
