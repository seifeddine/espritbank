package edu.esprit.banque.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_personne")
public class Personne implements Serializable{

	private Integer Id ;
	private int cin;
	private String nom ;
	private String prenom ;
	private String login;
	private String pass;
	private int age;
	private double sold;
	private boolean isadmin;
	
	
	//private Fiche fiche;
	
	//private List <Agence> Agences;


	public boolean isIsadmin() {
		return isadmin;
	}
	public double getSold() {
		return sold;
	}
	public void setSold(double sold) {
		this.sold = sold;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	
	/*@ManyToMany(mappedBy="clients")
	public List<Agence> getAgences() {
		return Agences;
	}
	public void setAgences(List<Agence> agences) {
		Agences = agences;
	}*/
	

	/*@OneToOne(cascade=CascadeType.PERSIST)
	public Fiche getFiche() {
		return fiche;
	}
	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	@Column(name="Name_client")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getCin() {
		return cin;
		}
		public void setCin(int cin) {
			this.cin = cin;
		}
		
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age
					+ "]";
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}

	
}
