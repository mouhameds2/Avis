package sully.group.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sully.group.sa.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
  Client findByEmail(String email);


}
