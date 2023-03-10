package com.softtech.softtechspringboot.app.acc.service;

import com.softtech.softtechspringboot.app.acc.converter.AccAccountMapper;
import com.softtech.softtechspringboot.app.acc.dto.AccAccountActivityDto;
import com.softtech.softtechspringboot.app.acc.dto.AccMoneyActivityRequestDto;
import com.softtech.softtechspringboot.app.acc.entity.AccAccount;
import com.softtech.softtechspringboot.app.acc.entity.AccAccountActivity;
import com.softtech.softtechspringboot.app.acc.enums.AccAccountActivityType;
import com.softtech.softtechspringboot.app.acc.enums.AccErrorMessage;
import com.softtech.softtechspringboot.app.acc.service.entityservice.AccAccountActivityEntityService;
import com.softtech.softtechspringboot.app.acc.service.entityservice.AccAccountEntityService;
import com.softtech.softtechspringboot.app.gen.exceptions.GenBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AccAccountActivityService {

    private final AccAccountEntityService accAccountEntityService;
    private final AccAccountActivityEntityService accAccountActivityEntityService;


    public AccAccountActivityDto withdraw(AccMoneyActivityRequestDto accMoneyActivityRequestDto) {

        Long accAccountId = accMoneyActivityRequestDto.getAccAccountId();
        BigDecimal amount = accMoneyActivityRequestDto.getAmount();

        AccAccountActivity accAccountActivity = moneyOut(accAccountId, amount, AccAccountActivityType.WITHDRAW);

        AccAccountActivityDto accAccountActivityDto = AccAccountMapper.INSTANCE.convertToAccAccountActivityDto(accAccountActivity);

        return accAccountActivityDto;
    }

    public AccAccountActivityDto deposit(AccMoneyActivityRequestDto accMoneyActivityRequestDto) {

        Long accAccountId = accMoneyActivityRequestDto.getAccAccountId();
        BigDecimal amount = accMoneyActivityRequestDto.getAmount();

        AccAccountActivity accAccountActivity = moneyIn(accAccountId, amount, AccAccountActivityType.DEPOSIT);

        AccAccountActivityDto accAccountActivityDto = AccAccountMapper.INSTANCE.convertToAccAccountActivityDto(accAccountActivity);

        return accAccountActivityDto;
    }

    public AccAccountActivity moneyOut(Long accountId, BigDecimal amount, AccAccountActivityType accountActivityType) {

        AccAccount accAccount = accAccountEntityService.getByIdWithControl(accountId);

        BigDecimal newBalance = accAccount.getCurrentBalance().subtract(amount);

        validateBalance(newBalance);

        AccAccountActivity accAccountActivity = createAccAccountActivity(accountId, amount, newBalance, accountActivityType);

        updateCurrentBalance(accAccount, newBalance);

        return accAccountActivity;
    }


    public AccAccountActivity moneyIn(Long accountId, BigDecimal amount, AccAccountActivityType accountActivityType) {

        AccAccount accAccount = accAccountEntityService.getByIdWithControl(accountId);

        BigDecimal newBalance = accAccount.getCurrentBalance().add(amount);

        AccAccountActivity accAccountActivity = createAccAccountActivity(accountId, amount, newBalance, accountActivityType);

        updateCurrentBalance(accAccount, newBalance);

        return accAccountActivity;
    }

    private AccAccountActivity createAccAccountActivity(Long accountId, BigDecimal amount, BigDecimal newBalance, AccAccountActivityType accAccountActivityType) {
        AccAccountActivity accAccountActivity = new AccAccountActivity();
        accAccountActivity.setAccountActivityType(accAccountActivityType);
        accAccountActivity.setAccAccountId(accountId);
        accAccountActivity.setAmount(amount);
        accAccountActivity.setTransactionDate(new Date());
        accAccountActivity.setCurrentBalance(newBalance);
        accAccountActivity = accAccountActivityEntityService.save(accAccountActivity);
        return accAccountActivity;
    }

    private static void validateBalance(BigDecimal newBalance) {
        if(newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new GenBusinessException(AccErrorMessage.INSUFFICIENT_BALANCE);
        }
    }

    private void updateCurrentBalance(AccAccount accAccount, BigDecimal newBalance) {
        accAccount.setCurrentBalance(newBalance);
        accAccount = accAccountEntityService.save(accAccount);
    }

}
