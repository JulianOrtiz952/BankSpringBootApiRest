package com.spring.rest.controllers;

import com.spring.rest.controllers.DTO.ClientDTO;
import com.spring.rest.models.Client;
import com.spring.rest.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    @Autowired
    private final ClientService clientService;

    @PostMapping("/saveClient")
    public ResponseEntity<?> createClient(@RequestBody Client client){
        clientService.createClient(client);
        return ResponseEntity.ok("client has been created");
    }

    @GetMapping("/getClient/{id}")
    public ResponseEntity<?> getClient(@PathVariable long id){
        Optional<Client> clientDTO = clientService.findById(id);
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping("/getAllClient")
    public ResponseEntity<?> getAllClient(){
        List<ClientDTO> clientListDTO = clientService.findAllClient().stream().map(client -> ClientDTO.builder().cc(client.getCc()).name(client.getName()).build()).toList();
        return ResponseEntity.ok(clientListDTO);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        clientService.deleteClient(id);
        return  ResponseEntity.ok("client has been deleted");
    }
}
