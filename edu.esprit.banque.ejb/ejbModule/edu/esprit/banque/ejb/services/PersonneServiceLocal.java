package edu.esprit.banque.ejb.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.banque.domain.Admin;
import edu.esprit.banque.domain.Personne;


@Local
public interface PersonneServiceLocal {
	public void addClient(Personne client);
	public Personne authenticate (String log , String pass);
	public void updateClient(Personne client);
	public Personne findClientByID(int id);
	public void deleteClient(Personne client);
	public List<Personne> findAllClients();
	public List<Personne> getClientByAge(int age);
	public Personne getClientByCin(int cin);
	public boolean transferSommeClient(Personne sender,Personne reciever,double somme);
	public Boolean Retirer(Personne sender,double somme);
	public double ShowSold(int id);

}
