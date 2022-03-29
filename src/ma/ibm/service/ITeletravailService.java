package ma.ibm.service;

import java.util.List;
import java.util.Map;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Teletravail;

public interface ITeletravailService {
	
	void saveTele(Teletravail tele);
	
	List<Teletravail> findTeleByIdCol(Long idCol);
	
	List<Teletravail> findTeleByMatDel(String matricule);
	
	List<Teletravail> findTeleByEqui(Long equipe);
	
	Map<String, Double> findTeleByIdColDate(Teletravail Exc);
	
	List<Teletravail> findall();
	
	List<Teletravail> findTeleByTypeYear(Long type,int year);
	
	List<Collaborateur> findTeleByInst();

}
