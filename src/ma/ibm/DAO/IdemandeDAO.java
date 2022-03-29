package ma.ibm.DAO;

import java.util.List;

import ma.ibm.modele.Demande;

public interface IdemandeDAO {

	public boolean saveDemande(Demande demande);
	
	public Demande findDemandeByIdDemande(Long idDemande);

	public List<Demande> findDemandeByIdCol(Long idCol);
	
	public List<Demande> findDemandeByStatutMatCol(Long statut,String matricule);
	
	public List<Demande> findDemandeByStatutMatDel(Long statut,String matricule);
	
	public List<Demande> findDemandeByStatutEqui(Long statut,Long equipe);
	
	public List<Demande> findDemandeByMatDel(String matricule);
	
	public List<Demande> findDemandeByEqui(Long equipe);	
	
	public List<Demande> findAllDemande();
	
	public List<Demande> findAllDemandeType(Long type);
	
	public List<Demande> findDemandeByTypeYear(Long type,int year);
	
	public List<Demande> findDemandeByEquiTypeYear(Long equipe,Long type,int year);
	
	public List<Demande> findDemandeByMatDelTypeYear(String matricule,Long type,int year);

}
