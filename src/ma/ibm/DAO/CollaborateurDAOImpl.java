package ma.ibm.DAO;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Role;

public class CollaborateurDAOImpl implements ICollaborateurDAO {
//--------------------------------------------------------------------------------------------------------------------------//
	public boolean saveCollaborateur(Collaborateur col) throws UnsupportedEncodingException {
		String login, password;
		login = col.getLogin();
		password = col.getPassword();
		login = LoginCrypt.loginHash(login);
		password = LoginCrypt.passHash(password);
		col.setLogin(login);
		col.setPassword(password);
		EntityTransaction tx = null;
		try {
			EntityManager em = EMF.get().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(col);
			tx.commit();
			if (em.isOpen()) {
				em.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public void deletCollaborateur(Long idCol) {
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		em.flush();
		em.clear();
		String sql = "DELETE Collaborateur c where c.idCol=:idCol";
		Query query = em.createQuery(sql);
		query.setParameter("idCol", idCol);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Collaborateur> findColByRole(Long idRole) {
		EntityManager em = EMF.get().createEntityManager();
		Role role = new Role();
		String sql = "SELECT c FROM Collaborateur c where c.role.idRole=:idRole";
		Query query = em.createQuery(sql);
		query.setParameter("idRole", idRole);
		List<Collaborateur> colls = query.getResultList();
		if (em.isOpen()) {
			em.close();
		}
		return colls;
	}
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public Collaborateur findColByMatricule(String matriculeCol) {
		EntityManager em = EMF.get().createEntityManager();
		Collaborateur coll;
		String sql = "SELECT c FROM Collaborateur c where c.matriculeCol=:matricule";

		Query query = em.createQuery(sql);
		query.setParameter("matricule", matriculeCol);
		List results = query.getResultList();
		if (results.isEmpty()) {
			if (em.isOpen()) {
				em.close();
			}
			return null;
		} else if (results.size() == 1) {
			coll = (Collaborateur) results.get(0);
			if (em.isOpen()) {
				em.close();
			}
			return coll;
		}
		throw new NonUniqueResultException();
	}

//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public Collaborateur findbyId(Long idCol) {
		EntityManager em = EMF.get().createEntityManager();
		Role role = new Role();
		String sql = "SELECT c FROM Collaborateur c where c.idCol=:idCol";
		Collaborateur coll = new Collaborateur();
		Query query = em.createQuery(sql);
		query.setParameter("idCol", idCol);
		List results = query.getResultList();
		if (results.isEmpty()) {
			if (em.isOpen()) {
				em.close();
			}
			return null;
		} else if (results.size() == 1) {
			coll = (Collaborateur) results.get(0);
			if (em.isOpen()) {
				em.close();
			}
			return coll;
		}
		throw new NonUniqueResultException();
	}
//--------------------------------------------------------------------------------------------------------------------------//	
	@Override
	public List<Collaborateur> findColAll() {
		EntityManager em = EMF.get().createEntityManager();
		String sql = "SELECT c FROM Collaborateur c";
		Query query = em.createQuery(sql);
		List<Collaborateur> cols = query.getResultList();
		if (em.isOpen()) {
			em.close();
		}
		return cols;
	}

	@Override
	public boolean editColRole(Long idCol, Role role) {
		try {
			EntityManager em = EMF.get().createEntityManager();
			Collaborateur col = em.find(Collaborateur.class, idCol);
			col.setRole(role);
			em.getTransaction().begin();
			em.merge(col);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
