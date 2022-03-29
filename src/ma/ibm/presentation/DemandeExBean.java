package ma.ibm.presentation;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Demande;
import ma.ibm.modele.Practice;
import ma.ibm.modele.Statut;
import ma.ibm.modele.Teletravail;
import ma.ibm.modele.TypeDemande;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IdemandeService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean(name = "demandeexbean")
@ViewScoped
public class DemandeExBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Demande demande = new Demande();
	private boolean disable = true;
	private boolean hide = false;
	private Date date1;
//------------------------------------------------------------------------------------------------------------------------//
	private String matriculeDelivery;
	private Collaborateur coll = new Collaborateur();
	private Statut statut = new Statut();
	private Practice practice = new Practice();
	private TypeDemande typeDemande = new TypeDemande();
	private IdemandeService demandeservice = new DemandeServiceImpl();
	private Map<String, Double> dureeOptionsMap;
	Teletravail tele = new Teletravail();
	ITeletravailService teleService = new TeletravailServiceImpl();
	private List<Double> invalidDays;

	@PostConstruct
	public void init() {

		dureeOptionsMap = new LinkedHashMap<String, Double>();
		coll = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		demande.setCol(coll);
		tele.setDemande(demande);

		dureeOptionsMap = teleService.findTeleByIdColDate(tele);

		invalidDays = new ArrayList<>();
		invalidDays.add(0.);
		invalidDays.add(6.);
	}

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
		coll = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		demande.setCol(coll);
		statut.setIdStatut(700L);
		demande.setStatut(statut);
		typeDemande.setIdTypeDemande(2L);
		demande.setTypeDemande(typeDemande);
		LocalDate d1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		demande.setDateEx1(d1);

		if (demandeservice.saveDemandeEx(demande)) {
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
		return coll;
	}

	public void setColab(Collaborateur colab) {
		this.coll = colab;
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

	public Map<String, Double> getDureeOptionsMap() {
		return dureeOptionsMap;
	}

	public void setDureeOptionsMap(Map<String, Double> dureeOptionsMap) {
		this.dureeOptionsMap = dureeOptionsMap;
	}

	public Teletravail getTele() {
		return tele;
	}

	public void setTele(Teletravail tele) {
		this.tele = tele;
	}

	public ITeletravailService getTeleService() {
		return teleService;
	}

	public void setTeleService(ITeletravailService teleService) {
		this.teleService = teleService;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	public Collaborateur getColl() {
		return coll;
	}

	public void setColl(Collaborateur coll) {
		this.coll = coll;
	}

	public List<Double> getInvalidDays() {
		return invalidDays;
	}

	public void setInvalidDays(List<Double> invalidDays) {
		this.invalidDays = invalidDays;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}
}
