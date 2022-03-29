package ma.ibm.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.faces.context.FacesContext;
import ma.ibm.DAO.DemandeDaoImpl;
import ma.ibm.DAO.IdemandeDAO;
import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Demande;

public class DemandeServiceImpl implements IdemandeService {

	private IdemandeDAO dao = new DemandeDaoImpl();
	private List<Demande> demandes;
//----------------------------------------------------------------------------------------------------------------------//	
	@Override
	public boolean saveDemandeEx(Demande demande) {
		
		return dao.saveDemande(demande);
		
	}
//-----------------------------------------------------------------------------------------------------------------------//
	@Override
	public boolean saveDemande(Demande demande) {
		
		Collaborateur coll = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		List<Demande> d1=findDemandeByStatutMatCol(700L,coll.getMatriculeCol());
		List<Demande> d2=findDemandeByStatutMatCol(800L,coll.getMatriculeCol());
		int j=0;
		int r=0;
		for(int i=0;i<d1.size();i++) {
			if(d1.get(i).getTypeDemande().getIdTypeDemande().equals(1L)) {
				j++;
			}
		}
		for(int i=0;i<d2.size();i++) {
			if(d2.get(i).getTypeDemande().getIdTypeDemande().equals(1L)) {
				r++;
			}
		}
		if(j!=0 || r!=0) {
			return false;
		}
		
		demandes=findDemandeByStatutMatCol(900L,coll.getMatriculeCol());
		if(demandes.size()==0){
				dao.saveDemande(demande);
				return true;}
		else{
			LocalDate max=demandes.get(0).getDateDemande();
			for (int i = 1; i < demandes.size(); i++) {
				if(demandes.get(i).getDateDemande().compareTo(max)>0) {
					max=demandes.get(i).getDateDemande();	
				}
			}
			
			
			if(ChronoUnit.MONTHS.between(max, LocalDate.now())>3) {
				dao.saveDemande(demande);
				return true;
		}		
	}
		return false;
		}
//------------------------------------------------------------------------------------------------------------------------//	
	@Override
	public List<Demande> findDemandeByIdCol(Long idCol) {
		return dao.findDemandeByIdCol(idCol);
	}
//-----------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByStatutMatDel(Long idStatut,String matricule) {
		
		return dao.findDemandeByStatutMatDel(idStatut,matricule);
	}
//-----------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByStatutEqui(Long idStatut,Long equipe) {
		
		return dao.findDemandeByStatutEqui(idStatut,equipe);
	}
//------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByStatutMatCol(Long idStatut, String matricule) {
		 demandes =dao.findDemandeByStatutMatCol(idStatut,matricule);
		 return demandes;
	}
//------------------------------------------------------------------------------------------------------------------------//
	public IdemandeDAO getDao() {
		return dao;
	}
	public void setDao(IdemandeDAO dao) {
		this.dao = dao;
	}
//------------------------------------------------------------------------------------------------------------------------//
	@Override
	public Demande findDemandeByIdDemande(Long idDemande) {
		return dao.findDemandeByIdDemande(idDemande);
	}
//------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findAllDemande()
	{
		demandes = dao.findAllDemande();
		return demandes;
	}
//------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByMatDel(String matriculeDel) {
		return dao.findDemandeByMatDel(matriculeDel);
	}
//------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByEqui(Long equipe) {
		return dao.findDemandeByEqui(equipe);
	}
//------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByTypeYear(Long type, int year) {
		return dao.findDemandeByTypeYear(type, year);
	}
//------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByEquiTypeYear(Long equipe,Long type,int year) {
		return dao.findDemandeByEquiTypeYear(equipe,type,year);
	}
//------------------------------------------------------------------------------------------------------------------------//	
	@Override
	public List<Demande> findDemandeByMatDelTypeYear(String matricule, Long type, int year) {
		return dao.findDemandeByMatDelTypeYear(matricule, type, year);
	}
	@Override
	public List<Demande> findAllDemandeType(Long type) {
		return dao.findAllDemandeType(type);
	}
}

