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

import edu.esprit.banque.domain.Agence;
import edu.esprit.banque.domain.Personne;
import edu.esprit.banque.ejb.services.AgenceServiceLocal;


@ManagedBean(name="AgenceMB")
@ViewScoped
public class AgenceManagedBean {

	private Agence agence = new Agence();
   
	private List<Agence> agences = new ArrayList<Agence>();
	
	private boolean displayForm=false;
	
	@EJB
	private AgenceServiceLocal agenceServiceLocal;
	

	public void setDisplayForm(boolean displayForm) {
		this.displayForm = displayForm;
	}

	public boolean isDisplayForm() {
		return displayForm;
	}

	public List<Agence> getAgences() {
		return agences;
	}
	
	public String showAddAgenceForm(){
		String navTo=null;
		agence=new Agence();
		displayForm=true;
		return navTo;
	}
	
	
	public String saveOrUpdateAgence(){
		String navTo=null;
		agenceServiceLocal.updateAgence(agence);
		agences= agenceServiceLocal.findAllAgence();
		displayForm=false;
		return navTo;
	}
	public Agence getAgence() {
		return agence;
	}
	
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	public void setAgence(List<Agence> agences) {
		this.agences = agences;
	}
	
	@PostConstruct
	public void init(){
		agences= agenceServiceLocal.findAllAgence();
	}

	
	
}
