package com.softtech.softtechspringboot.app.cus.service;

import com.softtech.softtechspringboot.app.cus.converter.CusCustomerConverter;
import com.softtech.softtechspringboot.app.cus.converter.CusCustomerMapper;
import com.softtech.softtechspringboot.app.cus.dto.CusCustomerDto;
import com.softtech.softtechspringboot.app.cus.dto.CusCustomerSaveRequestDto;
import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.service.entityservice.CusCustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CusCustomerService {

    private final CusCustomerEntityService cusCustomerEntityService;

    private final CusCustomerConverter cusCustomerConverter;
    public List<CusCustomerDto> findAll() {

        List<CusCustomer> cusCustomerList = cusCustomerEntityService.findAll();

        List<CusCustomerDto> cusCustomerDtoList = cusCustomerConverter.convertToCusCustomerDtoList(cusCustomerList);

        return cusCustomerDtoList;

    }

    public CusCustomerDto save(CusCustomerSaveRequestDto cusCustomerSaveRequestDto) {

        CusCustomer cusCustomer = CusCustomerMapper.INSTANCE.convertToCusCustomer(cusCustomerSaveRequestDto);

        cusCustomer = cusCustomerEntityService.save(cusCustomer);

        CusCustomerDto cusCustomerDto = CusCustomerMapper.INSTANCE.convertToCusCustomerDto(cusCustomer);

        return cusCustomerDto;
    }

    public void delete(Long id) {

        CusCustomer cusCustomer = cusCustomerEntityService.getByIdWithControl(id);

        cusCustomerEntityService.delete(cusCustomer);
    }

    public CusCustomerDto findById(Long id) {

        CusCustomer cusCustomer = cusCustomerEntityService.getByIdWithControl(id);

        CusCustomerDto cusCustomerDto = CusCustomerMapper.INSTANCE.convertToCusCustomerDto(cusCustomer);

        return cusCustomerDto;
    }

}
