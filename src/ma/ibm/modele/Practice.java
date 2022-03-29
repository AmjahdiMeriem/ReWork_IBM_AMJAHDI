package ma.ibm.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Practice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPractice;
	private String libPractice;
	@OneToMany(mappedBy = "practice", cascade = CascadeType.ALL)
	private List<Collaborateur> collaborateurPractice;
	
	
	public Long getIdPractice() {
		return idPractice;
	}
	public void setIdPractice(Long idPractice) {
		this.idPractice = idPractice;
	}
	public String getLibPractice() {
		return libPractice;
	}
	public void setLibPractice(String libPractice) {
		this.libPractice = libPractice;
	}
	
	
	
}
