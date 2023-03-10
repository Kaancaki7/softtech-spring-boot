package com.softtech.softtechspringboot.app.cus.converter;

import com.softtech.softtechspringboot.app.cus.dto.CusCustomerDto;
import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CusCustomerConverter {

    public List<CusCustomerDto> convertToCusCustomerDtoList(List<CusCustomer> cusCustomerList) {
        List<CusCustomerDto> cusCustomerDtoList = new ArrayList<>();
        for (CusCustomer cusCustomer : cusCustomerList) {

            CusCustomerDto cusCustomerDto = convertToCusCustomerDto(cusCustomer);

            cusCustomerDtoList.add(cusCustomerDto);
        }
        return cusCustomerDtoList;
    }

    public CusCustomerDto convertToCusCustomerDto(CusCustomer cusCustomer) {
            CusCustomerDto cusCustomerDto = new CusCustomerDto();
            cusCustomerDto.setId(cusCustomer.getId());
            cusCustomerDto.setName(cusCustomer.getName());
            cusCustomerDto.setSurName(cusCustomer.getSurName());
            cusCustomerDto.setIdentityNo(cusCustomer.getIdentityNo());

        return cusCustomerDto;
    }
}
