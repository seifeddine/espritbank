package edu.esprit.banque.webJSF.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.text.StyledEditorKit.BoldAction;

import edu.esprit.banque.domain.Client;
import edu.esprit.banque.ejb.services.ClientServiceLocal;


@ManagedBean(name="clientMB")
@ViewScoped
public class ClientManagedBean implements Serializable {
	
	private Client client = new Client();
	
	private List<Client> clients = new ArrayList<Client>();
	
	private boolean displayForm=false;
	
	@EJB
	private ClientServiceLocal clientServiceLocal;
	
	public String saveOrUpdateClient(){
		String navTo=null;
		clientServiceLocal.updateClient(client);
		clients= clientServiceLocal.findAllClients();
		displayForm=false;
		return navTo;
	}
	
	public String delete(){
		String navTo=null;
		clientServiceLocal.deleteClient(client);
		clients= clientServiceLocal.findAllClients();
		displayForm=false;
		return navTo;
	}
	
	public String cancel(){
		String navTo=null;
		displayForm=false;
		return navTo;
	}
	
	public String showAddClientForm(){
		String navTo=null;
		client=new Client();
		displayForm=true;
		return navTo;
	}
	
	
	@PostConstruct
	public void init(){
		clients= clientServiceLocal.findAllClients();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	public boolean isDisplayForm() {
		return displayForm;
	}


	public void setDisplayForm(boolean displayForm) {
		this.displayForm = displayForm;
	}
	

}
