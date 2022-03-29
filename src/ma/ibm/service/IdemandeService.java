package ma.ibm.service;

import java.util.List;

import ma.ibm.modele.Demande;

public interface IdemandeService {

	public boolean saveDemande(Demande demande);
	
	public boolean saveDemandeEx(Demande demande);
	
	public Demande findDemandeByIdDemande(Long idDemande);
	
	public List<Demande> findDemandeByIdCol(Long idCol);
	
	public List<Demande> findDemandeByStatutMatDel(Long idStatut,String matricule);
	
	public List<Demande> findDemandeByStatutEqui(Long idStatut,Long equipe);

	public List<Demande> findDemandeByStatutMatCol(Long idStatut,String matricule);
	
	public List<Demande> findDemandeByMatDel(String matriculeDel);
	
	public List<Demande> findDemandeByEqui(Long equipe);
	
	public List<Demande> findAllDemande();
	
	public List<Demande> findAllDemandeType(Long type);
	
	public List<Demande> findDemandeByTypeYear(Long type,int year);
	
	public List<Demande> findDemandeByEquiTypeYear(Long equipe,Long type,int year);
	
	public List<Demande> findDemandeByMatDelTypeYear(String matricule,Long type,int year);

}
