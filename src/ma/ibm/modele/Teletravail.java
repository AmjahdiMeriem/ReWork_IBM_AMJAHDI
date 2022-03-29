package ma.ibm.modele;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Teletravail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTele;
	
	private LocalDate dateDebut;
	private double dureeTele;
	
	@Transient
	private LocalDate dateFin;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
	@JoinColumn(name = "idDemande")
    private Demande demande;
	
	public Teletravail() {}

	public Long getIdTele() {
		return idTele;
	}

	public void setIdTele(Long idTele) {
		this.idTele = idTele;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	public double getDureeTele() {
		return dureeTele;
	}

	public void setDureeTele(double dureeTele) {
		this.dureeTele = dureeTele;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

}
