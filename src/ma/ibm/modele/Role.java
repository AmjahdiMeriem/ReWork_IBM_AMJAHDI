package ma.ibm.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	private String libRole;
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private List<Collaborateur> collaborateurRole;
	
	private static final Long collaborateurId = 1L;
	private static final Long deliveryManagerId = 2L;
	private static final Long peopleManagerId = 3L;
	
	public static Long getCollaborateurid() {
		return collaborateurId;
	}

	public static Long getDeliverymanagerid() {
		return deliveryManagerId;
	}

	public static Long getPeoplemanagerid() {
		return peopleManagerId;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getLibRole() {
		return libRole;
	}

	public void setLibRole(String libRole) {
		this.libRole = libRole;
	}

	public List<Collaborateur> getCollaborateurRole() {
		return collaborateurRole;
	}

	public void setCollaborateurRole(List<Collaborateur> collaborateurRole) {
		this.collaborateurRole = collaborateurRole;
	}

}
