package edu.esprit.banque.ejb.services;
import java.util.List;

import javax.ejb.Local;
import edu.esprit.banque.domain.Agence;

@Local
public interface AgenceServiceLocal {
	public List<Agence> findAllAgence();
	public void addAgence(Agence agence);
	public void updateAgence( Agence agence);
}
