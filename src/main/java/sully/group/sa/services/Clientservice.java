package sully.group.sa.services;

import sully.group.sa.dto.ClientDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sully.group.sa.entites.Client;
import sully.group.sa.mapper.ClientDTOMapper;
import sully.group.sa.repository.ClientRepository;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class Clientservice {

    private ClientRepository clientRepository;
    private final ClientDTOMapper clientDTOMapper;


    public Clientservice(ClientRepository clientRepository, ClientDTOMapper clientDTOMapper) {
        this.clientRepository = clientRepository;

        this.clientDTOMapper = clientDTOMapper;
    }

    public void createClient(Client client){
        Client mailClientDansDB= this.clientRepository.findByEmail(client.getEmail());
        if (mailClientDansDB==null) {
            System.out.println("===== le client " + client.getEmail() + " n'existe pas   ======");

            this.clientRepository.save(client);
        }
        else {
            throw new RuntimeException("===== le client avec l'e-mail " +"'"+ client.getEmail() +"'"+ " existe déjà  ======");
        }

    }

    public Stream<ClientDTO> clientList() {
      return this.clientRepository.findAll()
              .stream().map(clientDTOMapper);
    }


    public  Stream<ClientDTO> getClientId(int id) {
        Stream<ClientDTO> optionalClient = this.clientRepository.findById(id)
                .stream().map(clientDTOMapper);
        if (optionalClient==null){
            throw new EntityNotFoundException( "le client "+ id+ " n'existe pas");
        }
        return optionalClient;

    }

    public Client readOrCreateClient(Client clientAcreer) {
        Client ClientDansDB= this.clientRepository.findByEmail(clientAcreer.getEmail());
        if (ClientDansDB==null) {
            System.out.println("===== Nouveau client créé ======" );
            return this.clientRepository.save(clientAcreer);
        }else {
            new EntityNotFoundException("===== le client " + ClientDansDB.getEmail() + " existe déja en  ======");
        }
        return ClientDansDB;
    }

    public Client getClientByIdPourEdit(int id){
        Optional <Client> optionalClient2 = this.clientRepository.findById(id);
        return optionalClient2.orElseThrow(
                ()-> new EntityNotFoundException("le client " + id + " n'existe pas! Merci de modifier un client qui existe")

        );
    }


    public void editClient(int id, Client client) {


        Client clientAediter = this.getClientByIdPourEdit(id);

        if ((clientAediter.getId() == client.getId())){
            clientAediter.setEmail(client.getEmail());
            clientAediter.setPhone(client.getPhone());
            this.clientRepository.save(clientAediter);
        }
    }
}
