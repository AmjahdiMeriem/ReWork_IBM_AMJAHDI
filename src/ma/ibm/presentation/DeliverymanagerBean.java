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
import ma.ibm.modele.Practice;
import ma.ibm.modele.Role;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.CollaborateurServiceImpl;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IcollaborateurService;
import ma.ibm.service.IdemandeService;
import ma.ibm.service.IvalidationService;
import ma.ibm.service.TeletravailServiceImpl;
import ma.ibm.service.ValidationServiceImpl;

@ManagedBean(name = "deliverymanagerbean")
@ViewScoped
public class DeliverymanagerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collaborateur colab = new Collaborateur();
	private List<Demande> demandes;
	private IdemandeService demandeService = new DemandeServiceImpl();
	private IcollaborateurService colabservice = new CollaborateurServiceImpl();
	private Long size;
//-------------------------------------------------------------------------------------------------------------------//
	private IvalidationService validationService = new ValidationServiceImpl();
	private Demande demande = new Demande();
	private Practice practice = new Practice();
	Teletravail tele = new Teletravail();
	ITeletravailService teleService = new TeletravailServiceImpl();

//-------------------------------------------------------------------------------------------------------------------//	
	@PostConstruct
	public void init() {
		colab = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		if (colab.getRole().getIdRole() == Role.getDeliverymanagerid()) {
			demandes = demandeService.findDemandeByStatutMatDel(700L, colab.getMatriculeCol());
		}
		size = (long) demandes.size();

	}

//--------------------------------------------------------------------------------------------------------------------//
	public void valider() throws MessagingException {
		int i = 0;
		FacesContext context = FacesContext.getCurrentInstance();
		String id = context.getExternalContext().getRequestParameterMap().get("Id");
		Long idDemande = Long.parseLong(id);
		MailSender mail = new MailSender();
		if (validationService.valider(idDemande)) {
			demande = demandeService.findDemandeByIdDemande(idDemande);
			if (demande.getTypeDemande().getIdTypeDemande().equals(2L)) {
				colab = colabservice.findbyId(demande.getCol().getIdCol());
				demande.setCol(colab);
				tele.setDemande(demande);
				tele.setDureeTele(demande.getDuree());
				tele.setDateDebut(demande.getDateEx1());
				teleService.saveTele(tele);
			}
			init();
			context.addMessage(null, new FacesMessage("Demande validée", ""));
			i++;
			if (i != 0 && mail.sendMail(demande) != null) {
				MimeMessage msg = mail.sendMail(demande);
				Transport.send(msg);
				context.addMessage(null, new FacesMessage("Mail de confirmation envoyé", ""));
			}
		} else {

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Echec du traitement de la demande, veuillez réessayer ultérieurement. Si le problème persiste contactez l'administrateur"));
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
	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
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

	public IcollaborateurService getColabservice() {
		return colabservice;
	}

	public void setColabservice(IcollaborateurService colabservice) {
		this.colabservice = colabservice;
	}
}
