package com.spring.rest.services;

import com.spring.rest.models.Account;
import com.spring.rest.models.Client;
import com.spring.rest.repository.AccountRepository;
import com.spring.rest.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;

    public void createClient(Client client){
        clientRepository.save(client);
    }

    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }

    public List<Client> findAllClient(){
        return (List<Client>) clientRepository.findAll();
    };

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }

}
