package ma.ibm.modele;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Demande {

	@Id
	@GeneratedValue
	private Long idDemande;
	private LocalDate dateDemande;
	private String nomProjet;
	private String jourTele;
	private String lieuTele;
	private boolean vm;
	private boolean cnx;
	private String matriculeDelivery;
	private double duree;
	private LocalDate dateEx1;

	@ManyToOne
	@JoinColumn(name = "idStatut", nullable = true)
	private Statut statut;

	@ManyToOne
	@JoinColumn(name = "idCol", nullable = true)
	private Collaborateur col;

	@OneToOne(mappedBy = "demande", cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = true)
	private Teletravail tele;

	@ManyToOne
	@JoinColumn(name = "idTypeDemande", nullable = true)
	private TypeDemande typeDemande;

//---------------------------------------------------------------------//
	public Demande() {
		this.duree = 90.;
	}

	// -------------------------------------------------------------------
	public Long getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(Long idDemande) {
		this.idDemande = idDemande;
	}

	// -------------------------------------------------------------------
	public LocalDate getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(LocalDate dateDemande) {
		this.dateDemande = dateDemande;
	}

	// -------------------------------------------------------------------
	public String getJourTele() {
		return jourTele;
	}

	public void setJourTele(String jourTele) {
		this.jourTele = jourTele;
	}

	// -------------------------------------------------------------------
	public String getLieuTele() {
		return lieuTele;
	}

	public void setLieuTele(String lieuTele) {
		this.lieuTele = lieuTele;
	}

	// -------------------------------------------------------------------
	public boolean isVm() {
		return vm;
	}

	public void setVm(boolean vm) {
		this.vm = vm;
	}

	// -------------------------------------------------------------------
	public boolean isCnx() {
		return cnx;
	}

	public void setCnx(boolean cnx) {
		this.cnx = cnx;
	}

	// -------------------------------------------------------------------
	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	// -------------------------------------------------------------------
	public String getMatriculeDelivery() {
		return matriculeDelivery;
	}

	public void setMatriculeDelivery(String matriculeDelivery) {
		this.matriculeDelivery = matriculeDelivery;
	}

	// -------------------------------------------------------------------

	// -------------------------------------------------------------------
	public Collaborateur getCol() {
		return col;
	}

	public void setCol(Collaborateur col) {
		this.col = col;
	}

	// -------------------------------------------------------------------
	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	// -------------------------------------------------------------------

	public Teletravail getTele() {
		return tele;
	}

	public void setTele(Teletravail tele) {
		this.tele = tele;
	}

	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public LocalDate getDateEx1() {
		return dateEx1;
	}

	public void setDateEx1(LocalDate dateEx1) {
		this.dateEx1 = dateEx1;
	}

	// -------------------------------------------------------------------

}
