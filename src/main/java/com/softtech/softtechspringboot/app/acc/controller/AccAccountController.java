package com.softtech.softtechspringboot.app.acc.controller;

import com.softtech.softtechspringboot.app.acc.dto.AccAccountDto;
import com.softtech.softtechspringboot.app.acc.dto.AccAccountSaveRequestDto;
import com.softtech.softtechspringboot.app.acc.dto.AccMoneyTransferSaveRequestDto;
import com.softtech.softtechspringboot.app.acc.dto.AccMoneyWithdrawRequestDto;
import com.softtech.softtechspringboot.app.acc.service.AccAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
@RequiredArgsConstructor
public class AccAccountController {

    private final AccAccountService accAccountService;
    @GetMapping
    public ResponseEntity getAll(){

        List<AccAccountDto> accAccountDtoList = accAccountService.findAll();

        return ResponseEntity.ok(accAccountDtoList);
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        AccAccountDto accAccountDto = accAccountService.findById();

        return ResponseEntity.ok(accAccountDto);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody AccAccountSaveRequestDto accAccountSaveRequestDto){

    }
    @PatchMapping
    public ResponseEntity cancel(Long id){

    }

    public ResponseEntity transferMoney(@RequestBody AccMoneyTransferSaveRequestDto accMoneyTransferSaveRequestDto){

    }

    public ResponseEntity withdraw(@RequestBody AccMoneyWithdrawRequestDto accMoneyWithdrawRequestDto){

    }


}
