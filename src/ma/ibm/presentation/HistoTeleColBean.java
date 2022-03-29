package ma.ibm.presentation;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Role;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.CollaborateurServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IcollaborateurService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean(name = "histotelecolbean")
@ViewScoped
public class HistoTeleColBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Teletravail tele;
	private List<Teletravail> teles;
	private ITeletravailService TeleService = new TeletravailServiceImpl();
	private IcollaborateurService collService = new CollaborateurServiceImpl();
	private List<Teletravail> filteredTeles;
	Collaborateur coll = new Collaborateur();
	private List<LocalDate> fin = new ArrayList<LocalDate>();

//----------------------------------------------------------------------------------------------------------------------------------//	
	@PostConstruct
	void init() {

		Collaborateur coll = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("col");
		teles = TeleService.findTeleByIdCol(coll.getIdCol());
		for (int i = 0; i < teles.size(); i++) {
			fin.add(teles.get(i).getDateDebut().plusDays((long) teles.get(i).getDureeTele()));
		}
		List<Collaborateur> collsDel = collService.findColByRole(Role.getDeliverymanagerid());
		for (int i = 0; i < teles.size(); i++) {
			for (int j = 0; j < collsDel.size(); j++) {
				if (collsDel.get(j).getMatriculeCol().equals(teles.get(i).getDemande().getMatriculeDelivery())) {
					String nomDel = collsDel.get(j).getNomCol() + " " + collsDel.get(j).getPrenomCol();
					teles.get(i).getDemande().setMatriculeDelivery(nomDel);
				}
			}
		}
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

	public List<Teletravail> getTeles() {
		return teles;
	}

	public void setTeles(List<Teletravail> teles) {
		this.teles = teles;
	}

	public ITeletravailService getTeleService() {
		return TeleService;
	}

	public void setTeleService(ITeletravailService teleService) {
		TeleService = teleService;
	}

	public List<Teletravail> getFilteredTeles() {
		return filteredTeles;
	}

	public void setFilteredTeles(List<Teletravail> filteredTeles) {
		this.filteredTeles = filteredTeles;
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
