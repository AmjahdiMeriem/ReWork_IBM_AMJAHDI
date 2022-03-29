package ma.ibm.presentation;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Demande;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean(name = "listdureebean")
@ViewScoped
public class ListDureeBean {

	private Collaborateur coll = new Collaborateur();
	private Demande demande = new Demande();
	private Map<String, Double> dureeOptionsMap;
	Teletravail tele = new Teletravail();
	ITeletravailService teleService = new TeletravailServiceImpl();

	@PostConstruct
	public void init() {

		dureeOptionsMap = new LinkedHashMap<String, Double>();
		System.out.println(coll.getMatriculeCol());
		coll = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		demande.setCol(coll);
		tele.setDemande(demande);
		dureeOptionsMap = teleService.findTeleByIdColDate(tele);

	}

	public Collaborateur getColab() {
		return coll;
	}

	public void setColab(Collaborateur colab) {
		this.coll = colab;
	}

	public Map<String, Double> getDureeOptionsMap() {
		return dureeOptionsMap;
	}

	public void setDureeOptionsMap(Map<String, Double> dureeOptionsMap) {
		this.dureeOptionsMap = dureeOptionsMap;
	}

	public Collaborateur getColl() {
		return coll;
	}

	public void setColl(Collaborateur coll) {
		this.coll = coll;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
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

}
