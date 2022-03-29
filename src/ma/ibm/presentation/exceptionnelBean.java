package ma.ibm.presentation;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Demande;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.CollaborateurServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IcollaborateurService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean(name = "exceptionnelbean")
@SessionScoped

public class exceptionnelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Collaborateur coll = new Collaborateur();
	private IcollaborateurService collService = new CollaborateurServiceImpl();
	private String mat;

	private Map<String, Double> list;
	private Demande demande = new Demande();
//---------------------------------------------------------------------------------//	
	Teletravail tele = new Teletravail();
	ITeletravailService teleExcService = new TeletravailServiceImpl();

//---------------------------------------------------------------------------------//
	public String search() {
		list = new LinkedHashMap<String, Double>();

		coll = collService.findColByMatricule(mat);
		demande.setCol(coll);
		demande.setDateDemande(LocalDate.now());
		demande.setNomProjet(null);
		DayOfWeek s = LocalDate.now().getDayOfWeek();
		TextStyle style = null;
		Locale locale = null;
		demande.setJourTele(s.getDisplayName(style, locale));
		demande.setLieuTele(null);
		tele.setDemande(demande);

		coll = new Collaborateur();

		list = teleExcService.findTeleByIdColDate(tele);

		return "exceptionnel?faces-redirect=true";
	}

//--------------------------------------------------------------------------------//
	public void saveTeleEcx() {
		mat = null;
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			teleExcService.saveTele(tele);
			tele = new Teletravail();
			context.addMessage(null, new FacesMessage("Le télétravail exceptionnel a été bien enregistré"));
		} catch (Exception e) {
			System.out.println("Catch");
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Echec de l'enregistrement de télétravail, veuillez réessayer ultérieurement. Si le problème persiste contactez votre responsable"));
		}
	}

//--------------------------------------------------------------------------------//
	public Collaborateur getColl() {
		return coll;
	}

	public void setColl(Collaborateur coll) {
		this.coll = coll;
	}

//--------------------------------------------------------------------------------//
	public IcollaborateurService getCollService() {
		return collService;
	}

	public void setCollService(IcollaborateurService collService) {
		this.collService = collService;
	}

//--------------------------------------------------------------------------------//
	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}
//--------------------------------------------------------------------------------//

	public Demande getDemande() {
		return demande;
	}

	public Map<String, Double> getList() {
		return list;
	}

	public void setList(Map<String, Double> list) {
		this.list = list;
	}

	public Teletravail getTele() {
		return tele;
	}

	public void setTele(Teletravail tele) {
		this.tele = tele;
	}

	public ITeletravailService getTeleExcService() {
		return teleExcService;
	}

	public void setTeleExcService(ITeletravailService teleExcService) {
		this.teleExcService = teleExcService;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

}
