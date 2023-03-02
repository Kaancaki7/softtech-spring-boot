package com.softtech.softtechspringboot.app.crd.service;

import com.softtech.softtechspringboot.app.crd.converter.CrdCreditCardMapper;
import com.softtech.softtechspringboot.app.crd.dto.CrdCreditCardResponseDto;
import com.softtech.softtechspringboot.app.crd.dto.CrdCreditCardSaveRequestDto;
import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCard;
import com.softtech.softtechspringboot.app.crd.service.entityservice.CrdCreditCardEntityService;
import com.softtech.softtechspringboot.app.gen.enums.GenStatusType;
import com.softtech.softtechspringboot.app.gen.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrdCreditCardService {

    private final CrdCreditCardEntityService crdCreditCardEntityService;

    public List<CrdCreditCardResponseDto> findAll() {

        List<CrdCreditCard> crdCreditCardList = crdCreditCardEntityService.findAllByStatusType(GenStatusType.ACTIVE);

        List<CrdCreditCardResponseDto> result = CrdCreditCardMapper.INSTANCE.convertToCrdCreditCardResponseDtoList(crdCreditCardList);

        return result;
    }

    public CrdCreditCardResponseDto findById(Long id) {

        CrdCreditCard crdCreditCard = crdCreditCardEntityService.getByIdWithControl(id);

        CrdCreditCardResponseDto result = CrdCreditCardMapper.INSTANCE.convertToCrdCreditCardResponseDto(crdCreditCard);

        return result;
    }

    public CrdCreditCardResponseDto saveCreditCard(CrdCreditCardSaveRequestDto crdCreditCardSaveRequestDto) {

        Long cusCustomerId = crdCreditCardSaveRequestDto.getCusCustomerId();
        BigDecimal earning = crdCreditCardSaveRequestDto.getEarning();
        String cutOffDayStr = crdCreditCardSaveRequestDto.getCutOffDay();

        BigDecimal limit = calculatedLimit(earning);


        LocalDate cutOffDateLocal = getCutOffDateLocal(cutOffDayStr);
        Date dueDate = getDueDate(cutOffDateLocal);

        Date cutOffDate = DateUtil.convertToDate(cutOffDateLocal);

        CrdCreditCard crdCreditCard = createCrdCreditCard(cusCustomerId, limit, dueDate, cutOffDate);

        CrdCreditCardResponseDto crdCreditCardResponseDto = CrdCreditCardMapper.INSTANCE.convertToCrdCreditCardResponseDto(crdCreditCard);

        return crdCreditCardResponseDto;
    }

    private CrdCreditCard createCrdCreditCard(Long cusCustomerId, BigDecimal limit, Date dueDate, Date cutOffDate) {
        Date expireDate = getExpireDate();
        Long cardNo = getCardNo();
        Long cvvNo = getCvvNo();


        CrdCreditCard crdCreditCard = new CrdCreditCard();
        crdCreditCard.setCusCustomerId(cusCustomerId);
        crdCreditCard.setCardNo(cardNo);
        crdCreditCard.setCvvNo(cvvNo);
        crdCreditCard.setTotalLimit(limit);
        crdCreditCard.setCurrentDebt(BigDecimal.ZERO);
        crdCreditCard.setAvailableCardLimit(limit);
        crdCreditCard.setCutOffDate(cutOffDate);
        crdCreditCard.setDueDate(dueDate);
        crdCreditCard.setExpireDate(expireDate);
        crdCreditCard.setMinimumPaymentAmount(BigDecimal.ZERO);

        crdCreditCard = crdCreditCardEntityService.save(crdCreditCard);
        return crdCreditCard;
    }

    private static Date getExpireDate() {
        LocalDate expireDateLocal = getExpireDateLocal();
        Date expireDate = DateUtil.convertToDate(expireDateLocal);
        return expireDate;
    }

    private static Date getDueDate(LocalDate cutOffDateLocal) {
        LocalDate dueDateLocal = getDueDateLocal(cutOffDateLocal);
        Date dueDate = DateUtil.convertToDate(dueDateLocal);
        return dueDate;
    }

    private static LocalDate getExpireDateLocal() {
        LocalDate expireDateLocal = LocalDate.now().plusYears(3);
        return expireDateLocal;
    }

    private static LocalDate getDueDateLocal(LocalDate cutOffDateLocal) {
        LocalDate dueDateLocal = cutOffDateLocal.plusDays(10);
        return dueDateLocal;
    }

    private static LocalDate getCutOffDateLocal(String cutOffDayStr) {
        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        Month nextMonth = Month.of(currentMonth).plus(1);

        Integer cutOffDay = getCutOffDay(cutOffDayStr);
        LocalDate cutOffDateLocal = LocalDate.of(currentYear, nextMonth, cutOffDay);
        return cutOffDateLocal;
    }

    private static BigDecimal calculatedLimit(BigDecimal earning) {
        BigDecimal limit = earning.multiply(BigDecimal.valueOf(3));
        return limit;
    }

    private static Integer getCutOffDay(String cutOffDayStr) {
        if (StringUtils.hasText(cutOffDayStr)){
            cutOffDayStr = "1";
        }

        Integer cutOffDay = Integer.valueOf(cutOffDayStr);
        return cutOffDay;
    }

    private static Long getCvvNo() {
        Long cvvNo = 123L;
        return cvvNo;
    }

    private static Long getCardNo() {
        Long cardNo = 123456789123456L;
        return cardNo;
    }

    public void cancel(Long cardId) {

        CrdCreditCard crdCreditCard = crdCreditCardEntityService.getByIdWithControl(cardId);

        crdCreditCard.setStatusType(GenStatusType.PASSIVE);
        crdCreditCard.setCancelDate(new Date());

        crdCreditCardEntityService.save(crdCreditCard);
    }
}
