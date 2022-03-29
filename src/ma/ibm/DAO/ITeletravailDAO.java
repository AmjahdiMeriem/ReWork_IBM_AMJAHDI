package ma.ibm.DAO;

import java.util.List;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Teletravail;

public interface ITeletravailDAO {
	
		void saveTele(Teletravail tele);
		
		List<Teletravail> findTeleByIdCol(Long idCol);
		
		List<Teletravail> findTeleByMatDel(String matricule);
		
		List<Teletravail> findTeleByEqui(Long equipe);
		
		List<Teletravail> findTeleByIdColDateType(Long idCol,Long type);
		
		List<Teletravail> findall();
		
		List<Teletravail> findTeleByTypeYear(Long type,int year);
		
		List<Collaborateur> findTeleByInst();
		
}


