package edu.esprit.banque.webJSF.mb;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class ButtonBean {

	public void destroyWorld(ActionEvent actionEvent){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes",  "Succes.");
		
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
                    