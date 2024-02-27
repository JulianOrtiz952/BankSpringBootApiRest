package com.spring.rest.controllers.DTO;

import com.spring.rest.models.Client;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AccountDTO {

    private long accountNumber;
    private Client client;
    @Setter
    private double balance;


}
