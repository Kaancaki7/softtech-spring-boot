package com.softtech.softtechspringboot.app.crd.controller;

import com.softtech.softtechspringboot.app.crd.dao.CrdCreditCardDao;
import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/credit-card")
@RequiredArgsConstructor
public class CrdCreditCardController {

    private final CrdCreditCardDao crdCreditCardDao;

    @PostMapping
    public void save(@RequestBody CrdCreditCard crdCreditCard){

        crdCreditCard = crdCreditCardDao.save(crdCreditCard);

        return crdCreditCard;
    }
}
