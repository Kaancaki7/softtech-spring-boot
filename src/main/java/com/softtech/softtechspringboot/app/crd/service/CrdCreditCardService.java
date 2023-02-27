package com.softtech.softtechspringboot.app.crd.service;

import com.softtech.softtechspringboot.app.crd.dto.CrdCreditCardResponseDto;
import com.softtech.softtechspringboot.app.crd.dto.CrdCreditCardSaveRequestDto;
import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCard;
import com.softtech.softtechspringboot.app.crd.service.entityservice.CrdCreditCardEntityService;
import com.softtech.softtechspringboot.app.gen.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CrdCreditCardService {

    private CrdCreditCardEntityService crdCreditCardEntityService;

    public CrdCreditCardResponseDto saveCreditCard(CrdCreditCardSaveRequestDto crdCreditCardSaveRequestDto) {

        Long cusCustomerId = crdCreditCardSaveRequestDto.getCusCustomerId();
        BigDecimal earning = crdCreditCardSaveRequestDto.getEarning();
        String cutOffDayStr = crdCreditCardSaveRequestDto.getCutOffDay();

        if (StringUtils.hasText(cutOffDayStr)){
            cutOffDayStr = "1";
        }

        Integer cutOffDay = Integer.valueOf(cutOffDayStr);

        BigDecimal limit = earning.multiply(BigDecimal.valueOf(3));

        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        Month nextMonth = Month.of(currentMonth).plus(1);

        LocalDate cutOffDateLocal = LocalDate.of(currentYear, nextMonth, cutOffDay);
        LocalDate dueDateLocal = cutOffDateLocal.plusDays(10);
        LocalDate expireDateLocal = LocalDate.now().plusYears(3);

        Long cardNo = 123456789123456L;
        Long cvvNo = 123L;

        Date cutOffDate = DateUtil.convertToDate(cutOffDateLocal);
        Date dueDate = DateUtil.convertToDate(dueDateLocal);
        Date expireDate = DateUtil.convertToDate(expireDateLocal);


        CrdCreditCard crdCreditCard = new CrdCreditCard();
        crdCreditCard.setCusCustomerId(cusCustomerId);
        crdCreditCard.setCardNo();
        crdCreditCard.setCvvNo();
        crdCreditCard.setTotalLimit();
        crdCreditCard.setCurrentDebt(BigDecimal.ZERO);
        crdCreditCard.setAvailableCardLimit();
        crdCreditCard.setCutOffDate(cutOffDate);
        crdCreditCard.setDueDate(dueDate);
        crdCreditCard.setExpireDate(expireDate);
        crdCreditCard.setMinimumPaymentAmount(BigDecimal.ZERO);

    }
}
