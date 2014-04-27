package edu.esprit.banque.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_compte")

public class Compte implements Serializable {

	private int numCompte;
	private double solde;
	

	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public int getNumCompte() {
		return numCompte;
	}
	
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	
}
