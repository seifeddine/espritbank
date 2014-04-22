package edu.esprit.banque.ejb.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.banque.domain.Client;

@Remote
public interface ClientServiceRemote {
public void addClient(Client client);
public void updateClient(Client client);
public Client findClientByID(int id);
public void deleteClient(Client client);
public List<Client> findAllClients();
public List<Client> getClientByAge(int age);
public Client getClientByCin(int cin);
public Client authenticate (String log , String pass);
}
