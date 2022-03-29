package ma.ibm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ma.ibm.modele.Role;

public class RoleDAOImpl implements IRoleDAO{

	public boolean saveRole(Role role) {
		EntityTransaction tx = null;
		try {
			EntityManager em = EMF.get().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(role);
			tx.commit();
			if(em.isOpen()) {
				em.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		
	}
//-----------------------------------------------------------------------------------------//
	@Override
	public List<Role> findRoleAll() {
		EntityManager em=EMF.get().createEntityManager();
		String sql="SELECT r FROM Role r";
		Query query=em.createQuery(sql);
		return query.getResultList();
	}
	@Override
	public Role findRoleByLib(String lib) {
		EntityManager em=EMF.get().createEntityManager();
		String sql="SELECT r FROM Role r where r.libRole=:lib";
		Query query=em.createQuery(sql);
		query.setParameter("lib", lib);
		List results=query.getResultList();
		if (results.isEmpty()) {
			if(em.isOpen()) {
				em.close();
			}
			return null;
		} else if (results.size() == 1) {
			if(em.isOpen()) {
				em.close();
			}
			return (Role) results.get(0);
		}
		throw new NonUniqueResultException();
	}
}
