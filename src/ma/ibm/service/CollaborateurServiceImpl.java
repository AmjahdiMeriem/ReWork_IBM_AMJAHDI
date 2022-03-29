package ma.ibm.service;

import java.io.UnsupportedEncodingException;
import java.util.List;


import ma.ibm.DAO.CollaborateurDAOImpl;

import ma.ibm.DAO.ICollaborateurDAO;
import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Role;


public class CollaborateurServiceImpl implements IcollaborateurService {

	private ICollaborateurDAO dao = new CollaborateurDAOImpl();
//---------------------------------------------------------------------------------------------------------------------------//
	@Override
	public boolean saveCollaborateur(Collaborateur col) throws UnsupportedEncodingException {

		return dao.saveCollaborateur(col);
		}
//---------------------------------------------------------------------------------------------------------------------------//		
	@Override
	public void deletCollaborateur(Long idCol) {
		 dao.deletCollaborateur(idCol);
	}
//---------------------------------------------------------------------------------------------------------------------------//	
	@Override
	public List<Collaborateur> findColByRole(Long idRole) {
		List<Collaborateur> colls=dao.findColByRole(idRole);
		return colls;
	}
//---------------------------------------------------------------------------------------------------------------------------//
	@Override
	public Collaborateur findColByMatricule(String matriculeCol) {
		Collaborateur coll=dao.findColByMatricule(matriculeCol);
		return coll;
	}
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public Collaborateur findbyId(Long idCol) {
		Collaborateur coll = dao.findbyId(idCol);
		return coll;
	}
	@Override
	public List<Collaborateur> findColAll() {
		return dao.findColAll();
	}
	@Override
	public boolean editColRole(Long idCol, Role role) {
		return dao.editColRole(idCol, role);
	}

}
