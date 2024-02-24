package com.spring.rest.controllers.clientDTO;

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
