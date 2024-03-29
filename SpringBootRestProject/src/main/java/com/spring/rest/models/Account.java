package com.spring.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @OneToOne
    @JoinColumn(name = "fk_add_id", nullable = false)
    private Client client;

    @Setter
    private double balance;// the current balance
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;



}
