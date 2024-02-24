package com.spring.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @Column(name = "add_id")
    private long cc;
    @Setter
    private String name;



}


