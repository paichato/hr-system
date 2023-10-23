package com.paichato.payrollapi.services;

import com.paichato.payrollapi.domain.Payroll;
import com.paichato.payrollapi.feignClients.UserFeign;
import com.paichato.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollServices {

    private final Environment env;
    private final UserFeign userFeign;
    public Payroll getPayment(Long workerId, Payroll payroll){
        log.info("PAYROLL_SERVICE ::: GET REQUEST on " + env.getProperty("local.server.port")+ "port");
        try{
            var user=userFeign.findById(workerId).getBody();
            if(Objects.nonNull(user)){
                return  new Payroll(user.getName(),payroll.getDescription(), user.getHourylyPrice(),payroll.getWorkedHours(), payroll.getWorkedHours()*user.getHourylyPrice());
            }
        }catch (FeignException.NotFound ex){
            throw new ObjectNotFoundException("User not found");
        }catch (Exception ex){
            throw  new IllegalArgumentException("Illegal argument exception");
        }
        return  null;
    }
}
