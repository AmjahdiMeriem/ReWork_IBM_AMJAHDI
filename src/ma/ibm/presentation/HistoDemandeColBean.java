package ma.ibm.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Demande;
import ma.ibm.modele.Role;
import ma.ibm.service.CollaborateurServiceImpl;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.IcollaborateurService;
import ma.ibm.service.IdemandeService;

@ManagedBean(name = "histodemandecolbean")
@ViewScoped
public class HistoDemandeColBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Collaborateur colab = new Collaborateur();
	private List<Demande> demandes;
	private IdemandeService demandeService = new DemandeServiceImpl();
	private IcollaborateurService collService = new CollaborateurServiceImpl();
	private List<Demande> filteredDemandes;
	Demande demande = new Demande();

	private String nomDel;
	private String nomPeo;

//----------------------------------------------------------------------------------------------------------------------------------------------//	
	@PostConstruct
	public void init() {
		colab = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		demandes = demandeService.findDemandeByIdCol(colab.getIdCol());

		List<Collaborateur> collsDel = collService.findColByRole(Role.getDeliverymanagerid());
		for (int i = 0; i < demandes.size(); i++) {
			for (int j = 0; j < collsDel.size(); j++) {
				if (collsDel.get(j).getMatriculeCol().equals(demandes.get(i).getMatriculeDelivery())) {
					nomDel = collsDel.get(j).getNomCol() + " " + collsDel.get(j).getPrenomCol();
					demandes.get(i).setMatriculeDelivery(nomDel);
				}
			}
		}

	}

//----------------------------------------------------------------------------------------------------------------------------------------------//	
	public String getNomPeo() {
		return nomPeo;
	}

	public void setNomPeo(String nomPeo) {
		this.nomPeo = nomPeo;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------//	
	public String getNomDel() {
		return nomDel;
	}

	public void setNomDel(String nomDel) {
		this.nomDel = nomDel;
	}
//----------------------------------------------------------------------------------------------------------------------------------------------//	

	public IcollaborateurService getCollService() {
		return collService;
	}

	public void setCollService(IcollaborateurService collService) {
		this.collService = collService;
	}
//----------------------------------------------------------------------------------------------------------------------------------------------//	

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------//	
	public IdemandeService getDemandeService() {
		return demandeService;
	}

	public void setDemandeService(IdemandeService demandeService) {
		this.demandeService = demandeService;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------//	
	public Collaborateur getColab() {
		return colab;
	}

	public void setColab(Collaborateur colab) {
		this.colab = colab;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------//	
	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------------------------------------------------------------//	
	public List<Demande> getFilteredDemandes() {
		return filteredDemandes;
	}

	public void setFilteredDemandes(List<Demande> filteredDemandes) {
		this.filteredDemandes = filteredDemandes;
	}
}
