package edu.esprit.banque.webJSF.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.primefaces.model.chart.PieChartModel;

import edu.esprit.banque.domain.Personne;
import edu.esprit.banque.ejb.services.PersonneServiceLocal;


@ManagedBean(name="clientMB")
@ViewScoped
public class ClientManagedBean implements Serializable {
	
	private Personne client = new Personne();
    private PieChartModel pieModel;  
	private List<Personne> clients = new ArrayList<Personne>();
	
	private boolean displayForm=false;
	
	@EJB
	private PersonneServiceLocal clientServiceLocal;
	
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
		client=new Personne();
		displayForm=true;
		return navTo;
	}
	
	
	@PostConstruct
	public void init(){
		clients= clientServiceLocal.findAllClients();
	}

	public Personne getClient() {
		return client;
	}

	public void setClient(Personne client) {
		this.client = client;
	}

	public List<Personne> getClients() {
		return clients;
	}

	public void setClients(List<Personne> clients) {
		this.clients = clients;
	}


	public boolean isDisplayForm() {
		return displayForm;
	}


	public void setDisplayForm(boolean displayForm) {
		this.displayForm = displayForm;
	}
	
	public PieChartModel getPieModel() { 
		 createPieModel();  
        return pieModel;  
    }  
  
    private void createPieModel() {  
        pieModel = new PieChartModel();  
        for (final Personne p : clients) {
  
        pieModel.set(p.getNom(), p.getSold());  
   
    }  
    }
	

}
