package ma.ibm.presentation;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Practice;
import ma.ibm.service.CollaborateurServiceImpl;
import ma.ibm.service.IPracticeService;
import ma.ibm.service.IcollaborateurService;
import ma.ibm.service.PracticeServiceImpl;

@ManagedBean(name = "collectorview")
@ViewScoped
public class CollectorView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collaborateur col;
	private IcollaborateurService colService = new CollaborateurServiceImpl();
	private List<Collaborateur> cols = new ArrayList<Collaborateur>();
	private Practice practice;
	private IPracticeService praService = new PracticeServiceImpl();
	private List<Practice> practices = new ArrayList<Practice>();

	@PostConstruct
	public void init() {
		col = new Collaborateur();
		cols = colService.findColAll();
		practice = new Practice();
		practices = praService.findPracticeAll();
	}

	public void createNew() throws UnsupportedEncodingException {
		if (cols.contains(col)) {
			FacesMessage msg = new FacesMessage("Dublicated", "This collaborator has already been added");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			cols.add(col);
			col = new Collaborateur();
		}
	}

	public String reinit1() throws UnsupportedEncodingException {
		colService.saveCollaborateur(col);
		col = new Collaborateur();
		return null;
	}

	public String reinit2() {
		praService.savePractice(practice);
		practice = new Practice();
		return null;
	}

	public void deletCol() {
		FacesContext context = FacesContext.getCurrentInstance();
		String id = context.getExternalContext().getRequestParameterMap().get("Id");
		Long idCol = Long.parseLong(id);
		colService.deletCollaborateur(idCol);
		init();
		context.addMessage(null, new FacesMessage("Collaborateur Supprimé", ""));
	}

	public void deletPractice() {
		FacesContext context = FacesContext.getCurrentInstance();
		String id = context.getExternalContext().getRequestParameterMap().get("Id");
		Long idPractice = Long.parseLong(id);
		praService.deletPractice(idPractice);
		init();
		context.addMessage(null, new FacesMessage("Practice Supprimé", ""));
	}

	public Collaborateur getCol() {
		return col;
	}

	public List<Collaborateur> getCols() {
		return cols;
	}

	public IcollaborateurService getColService() {
		return colService;
	}

	public Practice getPractice() {
		return practice;
	}

	public List<Practice> getPractices() {
		return practices;
	}

}