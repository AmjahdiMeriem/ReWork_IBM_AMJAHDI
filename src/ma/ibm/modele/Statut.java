package ma.ibm.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Statut {
//-------------------------------------------------------------------------//
	@Id
	private Long idStatut;
	private String libelleStatut;
	@OneToMany(mappedBy = "statut",cascade = CascadeType.ALL)
	private List<Demande> demandeStatut;
//--------------------------------------------------------------------------------------------------------------------------//
	public Statut() {}
//------------------------------------------------------------------------//
	public Long getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(Long idStatut) {
		this.idStatut = idStatut;
	}
//-----------------------------------------------------------------------//
	public String getLibelleStatut() {
		return libelleStatut;
	}
	public void setLibelleStatut(String libelleStatut) {
		this.libelleStatut = libelleStatut;
	}
	
//---------------------------------------------------------------------//
	public List<Demande> getDemandeStatut() {
		return demandeStatut;
	}
	public void setDemandeStatut(List<Demande> demandeStatut) {
		this.demandeStatut = demandeStatut;
	}	
}
