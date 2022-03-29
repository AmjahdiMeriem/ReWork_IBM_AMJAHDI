package ma.ibm.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Demande;
import ma.ibm.modele.MailSender;
import ma.ibm.modele.Role;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IdemandeService;
import ma.ibm.service.IvalidationService;
import ma.ibm.service.TeletravailServiceImpl;
import ma.ibm.service.ValidationServiceImpl;

@ManagedBean(name = "peoplemanagerbean")
@ViewScoped
public class PeopleManagerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collaborateur colab = new Collaborateur();
	private List<Demande> demandes = null;
	private List<Demande> filteredDemandes;
	private IdemandeService demandeService = new DemandeServiceImpl();
	private Long size;
//-------------------------------------------------------------------------------------------------------------------//
	private IvalidationService validationService = new ValidationServiceImpl();
	private Demande demande = new Demande();
	private ITeletravailService teleService = new TeletravailServiceImpl();

//-------------------------------------------------------------------------------------------------------------------//
	@PostConstruct
	public void init() {
		colab = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		if (colab.getRole().getIdRole() == Role.getPeoplemanagerid()) {
			demandes = demandeService.findDemandeByStatutEqui(800L, colab.getEquipe().getIdEquipe());
		}
		size = (long) demandes.size();
	}

//-------------------------------------------------------------------------------------------------------------------//
	public void valider() throws MessagingException {
		int i = 0;
		FacesContext context = FacesContext.getCurrentInstance();
		String id = context.getExternalContext().getRequestParameterMap().get("Id");
		Long idDemande = Long.parseLong(id);
		MailSender mail = new MailSender();
		if (validationService.valider(idDemande)) {
			init();
			context.addMessage(null, new FacesMessage("Demande validée", ""));
			demande = demandeService.findDemandeByIdDemande(idDemande);
			Teletravail tele = new Teletravail();
			tele.setDemande(demande);
			tele.setDureeTele(90.);

			teleService.saveTele(tele);
			i++;
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Echec du traitement de la demande, veuillez réessayer ultérieurement. Si le problème persiste contactez l'administrateur"));
		}
		if (i != 0 && !(mail.sendMail(demande).equals(null))) {
			MimeMessage msg = mail.sendMail(demande);
			Transport.send(msg);
			context.addMessage(null, new FacesMessage("Mail de confirmation envoyé", ""));
		}
	}

//--------------------------------------------------------------------------------------------------------------------//
	public void refuser() throws MessagingException {
		int i = 0;
		FacesContext context = FacesContext.getCurrentInstance();
		String id = context.getExternalContext().getRequestParameterMap().get("Id");
		Long idDemande = Long.parseLong(id);
		demande.setIdDemande(idDemande);
		MailSender mail = new MailSender();
		if (validationService.refuser(idDemande)) {
			init();
			context.addMessage(null, new FacesMessage("Demande refusée", ""));
			i++;
			demande = demandeService.findDemandeByIdDemande(idDemande);

		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Echec du traitement de la demande, veuillez réessayer ultérieurement. Si le problème persiste contactez l'administrateur"));
		}
		if (i != 0 && !(mail.sendMail(demande).equals(null))) {
			MimeMessage msg = mail.sendMail(demande);
			Transport.send(msg);
			context.addMessage(null, new FacesMessage("Mail de confirmation envoyé", ""));
		}

	}

//--------------------------------------------------------------------------------------------------------------------//
	public Collaborateur getColab() {
		return colab;
	}

	public void setColab(Collaborateur colab) {
		this.colab = colab;
	}

//------------------------------------------------------------------------------------------------------------------//
	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

//-------------------------------------------------------------------------------------------------------------------//
	public IdemandeService getDemandeService() {
		return demandeService;
	}

	public void setDemandeService(IdemandeService demandeService) {
		this.demandeService = demandeService;
	}

//--------------------------------------------------------------------------------------------------------------------//
	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

//------------------------------------------------------------------------------------------------------------------//
	public IvalidationService getValidationService() {
		return validationService;
	}

	public void setValidationService(IvalidationService validationService) {
		this.validationService = validationService;
	}

//-----------------------------------------------------------------------------------------------------------------//
	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

//-----------------------------------------------------------------------------------------------------------------//	
	public List<Demande> getFilteredDemandes() {
		return filteredDemandes;
	}

	public ITeletravailService getTeleService() {
		return teleService;
	}

	public void setTeleService(ITeletravailService teleService) {
		this.teleService = teleService;
	}

	public void setFilteredDemandes(List<Demande> filteredDemandes) {
		this.filteredDemandes = filteredDemandes;
	}

}
