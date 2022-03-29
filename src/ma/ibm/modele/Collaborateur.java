package ma.ibm.modele;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Collaborateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCol;
	@Column(unique = true)
	private String matriculeCol;
	private String nomCol;
	private String prenomCol;
	private String tel1;
	private String tel2;
	private String mailCol;
	private LocalDate integration;
	private String login;
	private String password;
	@OneToMany(mappedBy = "col")
	private List<Demande> demandeCol;
	@ManyToOne
	@JoinColumn(name = "idPractice", nullable = true)
	private Practice practice;
	@ManyToOne
	@JoinColumn(name = "idRole", nullable = true)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "idEquipe",nullable=true)
	private Equipe equipe;
	// ----------------------------------------------------------------------------------------------------------------------
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
//-------------------------------------------------------------------------------------------------------------------------//
	public Collaborateur() {}

//-------------------------------------------------------------------------------------------------------------------------//
	public Long getIdCol() {
		return idCol;
	}

	public void setIdCol(Long idCol) {
		this.idCol = idCol;
	}

//-------------------------------------------------------------------------------------------------------------------------//
	public String getNomCol() {
		return nomCol;
	}

	public void setNomCol(String nomCol) {
		this.nomCol = nomCol;
	}

//-------------------------------------------------------------------------------------------------------------------------//
	public String getPrenomCol() {
		return prenomCol;
	}

	public void setPrenomCol(String prenomCol) {
		this.prenomCol = prenomCol;
	}

//-------------------------------------------------------------------------------------------------------------------------//	
	public String getTel1() {
		return tel1;
	}

	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

//-------------------------------------------------------------------------------------------------------------------------//
	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

//-------------------------------------------------------------------------------------------------------------------------//	
	public String getMatriculeCol() {
		return matriculeCol;
	}

	public void setMatriculeCol(String matriculeCol) {
		this.matriculeCol = matriculeCol;
	}

//-------------------------------------------------------------------------------------------------------------------------//	
	public LocalDate getIntegration() {
		return integration;
	}

	public void setIntegration(LocalDate integration) {
		this.integration = integration;
	}

//-------------------------------------------------------------------------------------------------------------------------//
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

//-------------------------------------------------------------------------------------------------------------------------//
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//-------------------------------------------------------------------------------------------------------------------------//	
	public List<Demande> getDemandeCol() {
		return demandeCol;
	}

	public void setDemandeCol(List<Demande> demandeCol) {
		this.demandeCol = demandeCol;
	}
//-------------------------------------------------------------------------------------------------------------------------//	

	public String getMailCol() {
		return mailCol;
	}

	public void setMailCol(String mailCol) {
		this.mailCol = mailCol;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
}
