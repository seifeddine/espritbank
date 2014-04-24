package edu.esprit.banque.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_fiche")
public class Fiche implements Serializable {

	private int id;
	private Date datenaiss;
	private String address;
	private Client client;
	
	/*@OneToOne(mappedBy="fiche")
	public Client getClient() {
		return client;
	}*/

	public void setClient(Client client) {
		this.client = client;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	@Temporal(TemporalType.DATE)
	public Date getDatenaiss() {
		return datenaiss;
	}


	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
