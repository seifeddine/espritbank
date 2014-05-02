package edu.esprit.banque.webJSF.mb;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.esprit.banque.domain.Personne;
import edu.esprit.banque.ejb.services.PersonneServiceLocal;

@ManagedBean(name="authenMB")
@SessionScoped
public class AuthentificationMangedBean implements Serializable {
	
	
	//Model
	private Personne client = new Personne();
	private String userType="";
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}



	@EJB
	PersonneServiceLocal clientServiceLocal;
	
	private boolean loggedIn=false;
	
	public String authentification(){
		String s=null;
		Personne found = clientServiceLocal.authenticate(client.getLogin(), client.getPass());
		
		
		if((found!=null)&&(found.isIsadmin()==false)){
			client=found;
			loggedIn=true;
			userType="Client";
			s= "/pages/client/homeClient";
		}
			
		
			
		else if((found!=null)&&(found.isIsadmin()==true)){
			client=found;
			loggedIn=true;
			userType="Admin";
			s= "/pages/admin/home";
			
		}
		
		else {
			loggedIn=false;
			FacesMessage message = new FacesMessage("Bad Credentials!");
			FacesContext.getCurrentInstance().addMessage("loginForm:loginButton", message);
			
		}
		
		return s;
	}
	
	public String logOut(){
		String navTo=null;
		client= new Personne();
		loggedIn=false;
		navTo="/pages/welcome";
		return navTo;
		
	}

	public Personne getClient() {
		return client;
	}

	public void setClient(Personne client) {
		this.client = client;
	}



	public boolean isLoggedIn() {
		return loggedIn;
	}



	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	

}
