package ma.ibm.DAO;

import java.io.UnsupportedEncodingException;
import java.util.List;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Role;

public interface ICollaborateurDAO {

	public boolean saveCollaborateur(Collaborateur col) throws UnsupportedEncodingException;
	
	public void deletCollaborateur(Long idCol);
	
	public Collaborateur findColByMatricule(String matricule);
	
	public List<Collaborateur> findColByRole(Long idRole);

	public Collaborateur findbyId(Long idCol);
	
	public List<Collaborateur> findColAll();
	
	public boolean editColRole(Long idCol,Role role);
	
}
