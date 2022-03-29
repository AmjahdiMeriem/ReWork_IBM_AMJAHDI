package ma.ibm.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Role;
import ma.ibm.service.CollaborateurServiceImpl;
import ma.ibm.service.IRoleService;
import ma.ibm.service.IcollaborateurService;
import ma.ibm.service.RoleServiceImpl;

@ManagedBean(name = "editrolebean")
@ViewScoped
public class editRoleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collaborateur col;
	private IcollaborateurService colService = new CollaborateurServiceImpl();
	private List<Collaborateur> cols = new ArrayList<Collaborateur>();
	private IRoleService roleService = new RoleServiceImpl();
	private List<Role> roles = new ArrayList<Role>();
	private List<String> libRoles = new ArrayList<String>();

	private List<Collaborateur> filteredCols;

	@PostConstruct
	public void init() {
		col = new Collaborateur();
		cols = colService.findColAll();
		roles = roleService.findRoleAll();
		for (int i = 0; i < roles.size(); i++) {
			libRoles.add(roles.get(i).getLibRole());
		}
	}

	public void onRowEdit(RowEditEvent event) {
		Long id = ((Collaborateur) event.getObject()).getIdCol();
		String lib = ((Collaborateur) event.getObject()).getRole().getLibRole();
		System.out.println(lib);
		Role r = roleService.findRoleByLib(lib);
		System.out.println(r.getIdRole());

		colService.editColRole(id, r);

		FacesMessage msg = new FacesMessage("Role Edited");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public Collaborateur getCol() {
		return col;
	}

	public void setCol(Collaborateur col) {
		this.col = col;
	}

	public IcollaborateurService getColService() {
		return colService;
	}

	public void setColService(IcollaborateurService colService) {
		this.colService = colService;
	}

	public List<Collaborateur> getCols() {
		return cols;
	}

	public void setCols(List<Collaborateur> cols) {
		this.cols = cols;
	}

	public List<String> getLibRoles() {
		return libRoles;
	}

	public void setLibRoles(List<String> libRoles) {
		this.libRoles = libRoles;
	}

	public List<Collaborateur> getFilteredCols() {
		return filteredCols;
	}

	public void setFilteredCols(List<Collaborateur> filteredCols) {
		this.filteredCols = filteredCols;
	}

}
