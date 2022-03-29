package ma.ibm.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.CollaborateurServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IcollaborateurService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean(name = "histoequipeobean")
@ViewScoped
public class HistoEquiPeoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Teletravail tele;
	private List<Teletravail> teles;
	private ITeletravailService teleService = new TeletravailServiceImpl();
	private IcollaborateurService collService = new CollaborateurServiceImpl();
	private List<Teletravail> filteredTeles;
	Collaborateur coll = new Collaborateur();

//----------------------------------------------------------------------------------------------------------------------------------//	
	@PostConstruct
	void init() {

		Collaborateur coll = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("col");
		teles = teleService.findTeleByEqui(coll.getEquipe().getIdEquipe());
		for (int i = 0; i < teles.size(); i++) {
			if (teles.get(i).getDemande().getTypeDemande().getIdTypeDemande() == 2L)
				teles.get(i).setDateFin(teles.get(i).getDateDebut().plusMonths(3));
			else {
				teles.get(i).setDateFin(teles.get(i).getDateDebut().plusDays((long) teles.get(i).getDureeTele()));
			}
		}
	}
//----------------------------------------------------------------------------------------------------------------------------------//

	public List<Teletravail> getFilteredTeles() {
		return filteredTeles;
	}

	public Teletravail getTele() {
		return tele;
	}

	public void setTele(Teletravail tele) {
		this.tele = tele;
	}

	public List<Teletravail> getTeles() {
		return teles;
	}

	public void setTeles(List<Teletravail> teles) {
		this.teles = teles;
	}

	public ITeletravailService getTeleService() {
		return teleService;
	}

	public void setTeleService(ITeletravailService teleService) {
		this.teleService = teleService;
	}

	public void setFilteredTeles(List<Teletravail> filteredTeles) {
		this.filteredTeles = filteredTeles;
	}

	public IcollaborateurService getCollService() {
		return collService;
	}

	public void setCollService(IcollaborateurService collService) {
		this.collService = collService;
	}

	public Collaborateur getColl() {
		return coll;
	}

	public void setColl(Collaborateur coll) {
		this.coll = coll;
	}

}
