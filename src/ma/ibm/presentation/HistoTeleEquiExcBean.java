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

@ManagedBean(name = "histoteleequiexcbean")
@ViewScoped
public class HistoTeleEquiExcBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Teletravail tele;
	private List<Teletravail> teleExcs;
	private ITeletravailService ExcService = new TeletravailServiceImpl();
	private IcollaborateurService collService = new CollaborateurServiceImpl();
	private List<Teletravail> filteredTeleRecs;
	Collaborateur coll = new Collaborateur();

//----------------------------------------------------------------------------------------------------------------------------------//	
	@PostConstruct
	void init() {
		Collaborateur coll = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("col");
		teleExcs = ExcService.findTeleByMatDel(coll.getMatriculeCol());
	}
//----------------------------------------------------------------------------------------------------------------------------------//

	public IcollaborateurService getCollService() {
		return collService;
	}

	public Teletravail getTele() {
		return tele;
	}

	public void setTele(Teletravail tele) {
		this.tele = tele;
	}

	public List<Teletravail> getTeleExcs() {
		return teleExcs;
	}

	public void setTeleExcs(List<Teletravail> teleExcs) {
		this.teleExcs = teleExcs;
	}

	public ITeletravailService getExcService() {
		return ExcService;
	}

	public void setExcService(ITeletravailService excService) {
		ExcService = excService;
	}

	public List<Teletravail> getFilteredTeleRecs() {
		return filteredTeleRecs;
	}

	public void setFilteredTeleRecs(List<Teletravail> filteredTeleRecs) {
		this.filteredTeleRecs = filteredTeleRecs;
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
