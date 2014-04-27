package edu.esprit.banque.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_agence")
public class Agence {

	private String nameAgence;
	private List <Personne> clients;

	@ManyToMany
	public List<Personne> getclients() {
		return clients;
	}

	public void setclients(List<Personne> clientlist) {
		this.clients = clientlist;
	}

	@Id
	public String getNameAgence() {
		return nameAgence;
	}

	public void setNameAgence(String nameAgence) {
		this.nameAgence = nameAgence;
	}
	
}
