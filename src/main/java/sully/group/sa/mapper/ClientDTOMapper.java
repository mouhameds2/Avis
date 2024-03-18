package sully.group.sa.mapper;

import sully.group.sa.dto.ClientDTO;
import org.springframework.stereotype.Component;
import sully.group.sa.entites.Client;

import java.util.function.Function;

@Component
public class ClientDTOMapper implements Function<Client, ClientDTO> {
    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(),client.getEmail(), client.getPhone());

   }
}
