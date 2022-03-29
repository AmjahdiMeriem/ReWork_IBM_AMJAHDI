package ma.ibm.presentation;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Demande;
import ma.ibm.modele.Role;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.IdemandeService;

@ManagedBean(name = "managerdemandebean")
@ViewScoped
public class ManagerDemandeBean {

	private Collaborateur colab = new Collaborateur();
	private List<Demande> demandes;
	private IdemandeService demandeService = new DemandeServiceImpl();
	private Long size;

	@PostConstruct
	public void init() {
		colab = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		if (colab.getRole().getIdRole() == Role.getDeliverymanagerid()) {
			demandes = demandeService.findDemandeByStatutMatDel(700L, colab.getMatriculeCol());
		} else if (colab.getRole().getIdRole() == Role.getPeoplemanagerid()) {
			demandes = demandeService.findDemandeByStatutMatDel(800L, colab.getMatriculeCol());
		}
		size = (long) demandes.size();
	}

	public Collaborateur getColab() {
		return colab;
	}

	public void setColab(Collaborateur colab) {
		this.colab = colab;
	}

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public IdemandeService getDemandeService() {
		return demandeService;
	}

	public void setDemandeService(IdemandeService demandeService) {
		this.demandeService = demandeService;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
