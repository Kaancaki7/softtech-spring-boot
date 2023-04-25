package com.softtech.softtechspringboot.app.transactional.controller;

import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import com.softtech.softtechspringboot.app.cus.service.entityservice.CusCustomerEntityService;
import com.softtech.softtechspringboot.app.transactional.service.NonTransactionalService;
import com.softtech.softtechspringboot.app.transactional.service.TransactionalService;
import com.softtech.softtechspringboot.app.transactional.util.TransactionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactional")
public class TransactionalController {

        private final TransactionalService transactionalService;
        private final NonTransactionalService nonTransactionalService;

        @PostMapping("/ts1")
        public void ts1(){
            nonTransactionalService.save();
        }

        @PostMapping("/ts2")
        public void ts2(){
                transactionalService.save();
        }

        @PostMapping("/ts3")
        public void ts3(){
                transactionalService.saveT2N();
        }

        @PostMapping("/ts4")
        public void ts4(){
                nonTransactionalService.saveN2T();
        }

        @PostMapping("/ts5")
        public void ts5(){
                transactionalService.saveT2T();
        }

        @PostMapping("/ts6")
        public void ts6(){
                transactionalService.saveButError();
        }

        @PostMapping("/ts7")
        public void ts7(){
                nonTransactionalService.saveButError();
        }

        @PostMapping("/ts8")
        public void ts8(){
                transactionalService.save();
        }

        @PostMapping("/ts9")
        public void ts9(){
                transactionalService.saveT2RNWithDifferentBean();
        }

        @PostMapping("/ts10")
        public void ts10(){
                transactionalService.saveT2RNButError();
        }

        @PostMapping("/ts11")
        public void ts11(){
                nonTransactionalService.saveN2Mandatory();
        }

        @PostMapping("/ts12")
        public void ts12(){
                transactionalService.saveMandatory();
        }

}
