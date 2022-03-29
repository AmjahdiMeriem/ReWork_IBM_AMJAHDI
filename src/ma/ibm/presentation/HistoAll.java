package ma.ibm.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ma.ibm.modele.Demande;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IdemandeService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean(name = "histoall")
@ViewScoped
public class HistoAll implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IdemandeService d = new DemandeServiceImpl();
	private ITeletravailService t = new TeletravailServiceImpl();
	private List<Demande> demandes = new ArrayList<Demande>();
	private List<Teletravail> teles = new ArrayList<Teletravail>();
	private Demande demande = new Demande();
	private Teletravail tele = new Teletravail();
	private List<Teletravail> filteredTeles;
	private List<Demande> filteredDemandes;

	@PostConstruct
	void init() {
		demandes = d.findAllDemande();
		teles = t.findall();
	}

	public IdemandeService getD() {
		return d;
	}

	public void setD(IdemandeService d) {
		this.d = d;
	}

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public ITeletravailService getT() {
		return t;
	}

	public void setT(ITeletravailService t) {
		this.t = t;
	}

	public List<Teletravail> getTeles() {
		return teles;
	}

	public void setTeles(List<Teletravail> teles) {
		this.teles = teles;
	}

	public Teletravail getTele() {
		return tele;
	}

	public void setTele(Teletravail tele) {
		this.tele = tele;
	}

	public List<Teletravail> getFilteredTeles() {
		return filteredTeles;
	}

	public void setFilteredTeles(List<Teletravail> filteredTeles) {
		this.filteredTeles = filteredTeles;
	}

	public List<Demande> getFilteredDemandes() {
		return filteredDemandes;
	}

	public void setFilteredDemandes(List<Demande> filteredDemandes) {
		this.filteredDemandes = filteredDemandes;
	}
}
