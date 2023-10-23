package com.paichato.payrollapi.resources;

import com.paichato.payrollapi.domain.Payroll;
import com.paichato.payrollapi.domain.User;
import com.paichato.payrollapi.feignClients.UserFeign;
import com.paichato.payrollapi.services.PayrollServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {


    private final PayrollServices service;

    @PostMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){


        return  ResponseEntity.ok().body(service.getPayment(workerId, payment));
    }
}
