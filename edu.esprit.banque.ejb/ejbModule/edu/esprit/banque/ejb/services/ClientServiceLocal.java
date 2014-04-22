package edu.esprit.banque.ejb.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.banque.domain.Client;


@Local
public interface ClientServiceLocal {
	public void addClient(Client client);
	public Client authenticate (String log , String pass);
	public void updateClient(Client client);
	public Client findClientByID(int id);
	public void deleteClient(Client client);
	public List<Client> findAllClients();
	public List<Client> getClientByAge(int age);
	public Client getClientByCin(int cin);

}
