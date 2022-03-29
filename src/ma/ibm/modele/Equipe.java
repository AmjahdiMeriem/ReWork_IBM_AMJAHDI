package ma.ibm.modele;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipe;
	
	@OneToMany(mappedBy = "equipe")
	private List<Collaborateur> colEquipe;

	public Long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}

	public List<Collaborateur> getColEquipe() {
		return colEquipe;
	}

	public void setColEquipe(List<Collaborateur> colEquipe) {
		this.colEquipe = colEquipe;
	}
}