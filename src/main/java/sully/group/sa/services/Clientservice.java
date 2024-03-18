package sully.group.sa.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sully.group.sa.entites.Client;
import sully.group.sa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class Clientservice {

    private ClientRepository clientRepository;

    public Clientservice(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(Client client){
        Client mailClientDansDB= this.clientRepository.findByEmail(client.getEmail());
        if (mailClientDansDB==null)
            this.clientRepository.save(client);

    }

    public List<Client> clientList() {
      return this.clientRepository.findAll() ;
    }


    public Client getClientId(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(
                () -> new EntityNotFoundException( "le client "+ id+ " n'existe pas")
        );
    }

    public Client readOrCreateClient(Client clientAcrer) {
        Client ClientDansDB= this.clientRepository.findByEmail(clientAcrer.getEmail());
        if (ClientDansDB==null) {
            System.out.println("===== Nouveau client créé ======" );
            return this.clientRepository.save(clientAcrer);
        }
        System.out.println("===== le client " + ClientDansDB.getEmail() + " existe déja en  ======");
        return ClientDansDB;
    }


    public void editClient(int id, Client client) {
        Client clientAedit = this.getClientId(id);
        if (clientAedit.getId() == client.getId()){
            clientAedit.setEmail(client.getEmail());
            clientAedit.setPhone(client.getPhone());
            this.clientRepository.save(clientAedit);
        }
    }
}