package ma.ibm.presentation;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Practice;
import ma.ibm.modele.Role;
import ma.ibm.service.CollaborateurServiceImpl;
import ma.ibm.service.IcollaborateurService;
import ma.ibm.service.IloginService;
import ma.ibm.service.LoginServiceImpl;

@ManagedBean
@SessionScoped
public class Collaborateurbean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 858065068621359071L;
//---------------------------------------------------------------------------------------------------------------------------//	
	private Collaborateur col = new Collaborateur();
	private IcollaborateurService colservice = new CollaborateurServiceImpl();
	private Role role = new Role();
	private Practice practice = new Practice();
	private Long idPractice;
	private boolean disabled = false;
//---------------------------------------------------------------------------------------------------------------------------//	
	private IloginService loginservice = new LoginServiceImpl();
	private String nomPrenom;

//---------------------------------------------------------------------------------------------------------------------------//
	public String saveColab() throws UnsupportedEncodingException {
		role.setIdRole(28L);
		col.setRole(role);
		practice.setIdPractice(idPractice);
		col.setPractice(practice);
		col.setMatriculeCol(
				col.getNomCol().charAt(0) + "" + col.getPrenomCol().charAt(0) + "" + col.getLogin().hashCode());
		if (colservice.saveCollaborateur(col)) {
			col = new Collaborateur();
			return "/authentification/login?faces-redirect=true";
		} else {
			return "Collaborateur/collaborateur?faces-redirect=true";
		}
	}

//--------------------------------------------------------------------------------------------------------------------------//
	public String recupColab() throws UnsupportedEncodingException {
		col = loginservice.checkLogin(col);
		if (col == null) {
			col = new Collaborateur();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					" mote de passe erroné", "Mail ou mote de passe est incorrect"));
			return null;
		} else {
			setNomPrenom(col.getPrenomCol() + " " + col.getNomCol());
			col.setLogin("");
			col.setPassword("");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("col", col);
			if (col.getRole().getIdRole() == Role.getCollaborateurid()) {

				if (ChronoUnit.YEARS.between(col.getIntegration(), LocalDate.now()) >= 1) {
					setDisabled(false);
				} else {
					setDisabled(true);
				}

				return "/Collaborateur/acceuil?faces-redirect=true";
			} else if (col.getRole().getIdRole() == Role.getDeliverymanagerid()) {
				return "/DeliveryManager/acceuil?faces-redirect=true";
			}

			else if (col.getRole().getIdRole() == Role.getPeoplemanagerid()) {
				return "/PeopleManager/acceuil?faces-redirect=true";
			}

			return "errorpage";
		}
	}

//--------------------------------------------------------------------------------------------------------------------------//
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/authentification/login?faces-redirect=true";
	}

//--------------------------------------------------------------------------------------------------------------------------//	   
	public Collaborateur getCol() {
		return col;
	}

	public void setCol(Collaborateur col) {
		this.col = col;
	}

//---------------------------------------------------------------------------------------------------------------------------//		
	public IcollaborateurService getColservice() {
		return colservice;
	}

	public void setColservice(IcollaborateurService colservice) {
		this.colservice = colservice;
	}

//--------------------------------------------------------------------------------------------------------------------------//		
	public void setLoginservice(IloginService loginservice) {
		this.loginservice = loginservice;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

//--------------------------------------------------------------------------------------------------------------------------//
	public String getNomPrenom() {
		return nomPrenom;
	}

	public IloginService getLoginservice() {
		return loginservice;
	}

//---------------------------------------------------------------------------------------------------------------------------//	
	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getIdPractice() {
		return idPractice;
	}

	public void setIdPractice(Long idPractice) {
		this.idPractice = idPractice;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
}