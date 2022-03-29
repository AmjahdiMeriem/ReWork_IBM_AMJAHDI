package ma.ibm.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ma.ibm.modele.Collaborateur;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean(name = "enligne")
@ViewScoped
public class EnLigne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ITeletravailService teleService = new TeletravailServiceImpl();

	private List<Collaborateur> colls = new ArrayList<Collaborateur>();

	private Collaborateur coll = new Collaborateur();

	private List<Collaborateur> filteredColls;

	public List<Collaborateur> init() {

		colls = teleService.findTeleByInst();
		return colls;
	}

	public ITeletravailService getTeleService() {
		return teleService;
	}

	public List<Collaborateur> getColls() {
		return colls;
	}

	public Collaborateur getColl() {
		return coll;
	}

	public List<Collaborateur> getFilteredColls() {
		return filteredColls;
	}

	public void setTeleService(ITeletravailService teleService) {
		this.teleService = teleService;
	}

	public void setColls(List<Collaborateur> colls) {
		this.colls = colls;
	}

	public void setColl(Collaborateur coll) {
		this.coll = coll;
	}

	public void setFilteredColls(List<Collaborateur> filteredColls) {
		this.filteredColls = filteredColls;
	}

}
