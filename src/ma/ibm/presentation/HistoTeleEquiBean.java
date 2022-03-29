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

@ManagedBean(name = "histoteleequibean")
@ViewScoped
public class HistoTeleEquiBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Teletravail tele;
	private List<Teletravail> teles;
	private ITeletravailService RecService = new TeletravailServiceImpl();
	private IcollaborateurService collService = new CollaborateurServiceImpl();
	private List<Teletravail> filteredTeles;
	Collaborateur coll = new Collaborateur();

//----------------------------------------------------------------------------------------------------------------------------------//	
	@PostConstruct
	void init() {

		Collaborateur coll = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("col");
		teles = RecService.findTeleByMatDel(coll.getMatriculeCol());
	}

//----------------------------------------------------------------------------------------------------------------------------------//
	public List<Teletravail> getTeleRecs() {
		return teles;
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

	public ITeletravailService getRecService() {
		return RecService;
	}

	public void setRecService(ITeletravailService recService) {
		RecService = recService;
	}

	public List<Teletravail> getFilteredTeles() {
		return filteredTeles;
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
