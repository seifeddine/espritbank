package edu.esprit.banque.webJSF.mb;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.esprit.banque.domain.Client;
import edu.esprit.banque.ejb.services.ClientServiceLocal;

@ManagedBean(name="authenMB")
@SessionScoped
public class AuthentificationMangedBean implements Serializable {
	
	
	//Model
	private Client client = new Client();
	
	@EJB
	ClientServiceLocal clientServiceLocal;
	
	private boolean loggedIn=false;
	
	public String authentification(){
		String s=null;
		Client found = clientServiceLocal.authenticate(client.getLogin(), client.getPass());
		if(found!=null){
			client=found;
			loggedIn=true;
			s= "/pages/client/home";
		} else {
			loggedIn=false;
			FacesMessage message = new FacesMessage("Bad Credentials!");
			FacesContext.getCurrentInstance().addMessage("loginForm:loginButton", message);
			
		}
		
		return s;
	}
	
	public String logOut(){
		String navTo=null;
		client= new Client();
		loggedIn=false;
		navTo="/pages/welcome";
		return navTo;
		
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}



	public boolean isLoggedIn() {
		return loggedIn;
	}



	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	

}
