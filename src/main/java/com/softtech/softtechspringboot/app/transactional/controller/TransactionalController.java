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
}