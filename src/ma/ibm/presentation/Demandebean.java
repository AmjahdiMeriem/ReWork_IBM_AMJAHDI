package ma.ibm.presentation;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Demande;
import ma.ibm.modele.Practice;
import ma.ibm.modele.Statut;
import ma.ibm.modele.TypeDemande;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.IdemandeService;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Demandebean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8264402925225029831L;
	private Demande demande = new Demande();
	private boolean disable = true;

//------------------------------------------------------------------------------------------------------------------------//
	private String matriculeDelivery;
	private Collaborateur colab = new Collaborateur();
	private Statut statut = new Statut();
	private Practice practice = new Practice();
	private TypeDemande typeDemande = new TypeDemande();
	private IdemandeService demandeservice = new DemandeServiceImpl();

//-----------------------------------------------------------------------------------------------------------------------//
	public void checkState() {
		if ((demande.isCnx() == true) && (demande.isVm() == true)) {
			setDisable(false);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!",
					"La demande ne pourra pas être crée si vous ne disposez pas de connection internet ou bien si la VM n'est pas opérationnelle !."));
		} else {
			setDisable(true);
		}
	}

//---------------------------------------------------------------------------------------------------------------------------//
	public void addDemande() {
		FacesContext context = FacesContext.getCurrentInstance();
		demande.setMatriculeDelivery(getMatriculeDelivery());
		colab = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		demande.setCol(colab);
		statut.setIdStatut(700L);
		demande.setStatut(statut);
		typeDemande.setIdTypeDemande(1L);
		demande.setTypeDemande(typeDemande);
		if (demandeservice.saveDemande(demande)) {
			context.addMessage(null, new FacesMessage("Félicitations", "Votre demande a été bien enregistré"));
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Echec de l'enregistrement de la demande, veuillez réessayer ultérieurement. Si le problème persiste contactez votre responsable"));
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------//
	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

//---------------------------------------------------------------------------------------------------------------------------//
	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

//---------------------------------------------------------------------------------------------------------------------------//
	public String getMatriculeDelivery() {
		return matriculeDelivery;
	}

	public void setMatriculeDelivery(String matriculeDelivery) {
		this.matriculeDelivery = matriculeDelivery;
	}
//-----------------------------------------------------------------------------------------------------------------------------//

//----------------------------------------------------------------------------------------------------------------------------//
	public Collaborateur getColab() {
		return colab;
	}

	public void setColab(Collaborateur colab) {
		this.colab = colab;
	}

//---------------------------------------------------------------------------------------------------------------------------//
	public IdemandeService getDemandeservice() {
		return demandeservice;
	}

	public void setDemandeservice(IdemandeService demandeservice) {
		this.demandeservice = demandeservice;
	}

//--------------------------------------------------------------------------------------------------------------------------//	
	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}

}
