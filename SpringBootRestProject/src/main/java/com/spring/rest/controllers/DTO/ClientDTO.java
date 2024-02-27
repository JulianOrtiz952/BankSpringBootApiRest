package com.spring.rest.controllers.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ClientDTO {

    private long cc;
    @Setter
    private String name;

}
