package com.paichato.payrollapi.domain;

import lombok.*;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String password;
    private String email;
    private Double hourylyPrice;


}
