package com.softtech.softtechspringboot.app.transactional.util;

import com.softtech.softtechspringboot.app.cus.entity.CusCustomer;
import org.springframework.util.StringUtils;

public class TransactionalUtil {


    public static CusCustomer getDummyCusCustomer(String suffix){

        String testName = "test";
        if (StringUtils.hasText(suffix)){
            testName = testName + "-" + suffix;
        }

        CusCustomer cusCustomer = new CusCustomer();
        cusCustomer.setName(testName);
        cusCustomer.setSurName(testName);
        cusCustomer.setIdentityNo(12312312312L);
        cusCustomer.setPassword("123");
        return cusCustomer;
    }
}
