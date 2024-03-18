package sully.group.sa.controller;

import sully.group.sa.dto.ClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sully.group.sa.entites.Client;
import sully.group.sa.services.Clientservice;

import java.util.stream.Stream;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    private Clientservice clientservice;

    public ClientController(Clientservice clientservice) {
        this.clientservice = clientservice;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping( consumes = APPLICATION_JSON_VALUE)
    public void createClient(@RequestBody Client client){
        this.clientservice.createClient(client);

    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Stream<ClientDTO> clientList() {
       return this.clientservice.clientList();
    }
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Stream<ClientDTO> getClientId(@PathVariable int id){

        return  this.clientservice.getClientId(id);


    }
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(path = "{id}",produces = APPLICATION_JSON_VALUE)
    public void editClient(@PathVariable int id, @RequestBody Client client){
        this.clientservice.editClient(id,client);
    }
}
