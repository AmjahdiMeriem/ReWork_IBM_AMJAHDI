package ma.ibm.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Role;
import ma.ibm.service.CollaborateurServiceImpl;
import ma.ibm.service.IcollaborateurService;

@ManagedBean(name = "listbymatriculebean")
@ViewScoped
public class ListByMatriculebean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8223533789847163326L;
//-----------------------------------------------------------------------------------------------------------------------//
	private String matriculeDelivery;
	private String matriculePeople;

	private IcollaborateurService collService = new CollaborateurServiceImpl();
	private List<Collaborateur> colls = new ArrayList<Collaborateur>();
	private Map<String, String> mats = new LinkedHashMap<String, String>();
	private String s;

	private Map<String, String> deliveryOptionsMap = new LinkedHashMap<>();
	private List<Collaborateur> deli = new ArrayList<Collaborateur>();

	private Map<String, String> peopleOptionsMap = new LinkedHashMap<>();
	private List<Collaborateur> people = new ArrayList<Collaborateur>();

	private IcollaborateurService colservice = new CollaborateurServiceImpl();

//---------------------------------------------------------------------------------------------------------------------------//
	@PostConstruct
	public void init() {
		colls = collService.findColAll();
		for (int i = 0; i < colls.size(); i++) {
			s = colls.get(i).getNomCol() + " " + colls.get(i).getPrenomCol() + " " + colls.get(i).getMatriculeCol();
			mats.put(s, colls.get(i).getMatriculeCol());
		}
		// Fill DeliverMap
		deli = colservice.findColByRole(Role.getDeliverymanagerid());
		for (int i = 0; i < deli.size(); i++) {
			String np = (deli.get(i).getNomCol() + " " + deli.get(i).getPrenomCol());
			deliveryOptionsMap.put(np, deli.get(i).getMatriculeCol());
		}
		// Fill PeopleMap
		people = colservice.findColByRole(Role.getPeoplemanagerid());
		for (int i = 0; i < people.size(); i++) {
			String np = (people.get(i).getNomCol() + " " + people.get(i).getPrenomCol());
			peopleOptionsMap.put(np, people.get(i).getMatriculeCol());
		}
	}

//----------------------------------------------------------------------------------------------------------------------------//
	public String getMatriculeDelivery() {
		return matriculeDelivery;
	}

	public void setMatriculeDelivery(String matriculeDelivery) {
		this.matriculeDelivery = matriculeDelivery;
	}

//----------------------------------------------------------------------------------------------------------------------------//
	public String getMatriculePeople() {
		return matriculePeople;
	}

	public void setMatriculePeople(String matriculePeople) {
		this.matriculePeople = matriculePeople;
	}

//----------------------------------------------------------------------------------------------------------------------------//
	public Map<String, String> getDeliveryOptionsMap() {
		return deliveryOptionsMap;
	}

	public void setDeliveryOptionsMap(Map<String, String> deliveryOptionsMap) {
		this.deliveryOptionsMap = deliveryOptionsMap;
	}

//----------------------------------------------------------------------------------------------------------------------------//
	public Map<String, String> getPeopleOptionsMap() {
		return peopleOptionsMap;
	}

	public void setPeopleOptionsMap(Map<String, String> peopleOptionsMap) {
		this.peopleOptionsMap = peopleOptionsMap;
	}

//---------------------------------------------------------------------------------------------------------------------------//
	public List<Collaborateur> getDeli() {
		return deli;
	}

	public void setDeli(List<Collaborateur> deli) {
		this.deli = deli;
	}

//--------------------------------------------------------------------------------------------------------------------------//
	public List<Collaborateur> getPeople() {
		return people;
	}

	public void setPeople(List<Collaborateur> people) {
		this.people = people;
	}

//--------------------------------------------------------------------------------------------------------------------------//
	public IcollaborateurService getColservice() {
		return colservice;
	}

	public void setColservice(IcollaborateurService colservice) {
		this.colservice = colservice;
	}

//---------------------------------------------------------------------------------------------------------------------------//
	public IcollaborateurService getCollService() {
		return collService;
	}

	public void setCollService(IcollaborateurService collService) {
		this.collService = collService;
	}

	public List<Collaborateur> getColls() {
		return colls;
	}

	public void setColls(List<Collaborateur> colls) {
		this.colls = colls;
	}

	public Map<String, String> getMats() {
		return mats;
	}

	public void setMats(Map<String, String> mats) {
		this.mats = mats;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
