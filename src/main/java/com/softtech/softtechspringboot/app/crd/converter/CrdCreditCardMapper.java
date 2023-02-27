package com.softtech.softtechspringboot.app.crd.converter;

import com.softtech.softtechspringboot.app.crd.dto.CrdCreditCardResponseDto;
import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CrdCreditCardMapper {

    CrdCreditCardMapper INSTANCE = Mappers.getMapper(CrdCreditCardMapper.class);

    CrdCreditCardResponseDto convertToCrdCreditCardResponseDto(CrdCreditCard crdCreditCard);
}
