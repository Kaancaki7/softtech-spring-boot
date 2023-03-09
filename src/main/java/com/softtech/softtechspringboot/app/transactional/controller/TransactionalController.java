package com.softtech.softtechspringboot.app.transactional.controller;

import com.softtech.softtechspringboot.app.transactional.service.NonTransactionalService;
import com.softtech.softtechspringboot.app.transactional.service.TransactionalService;
import lombok.RequiredArgsConstructor;
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
}
