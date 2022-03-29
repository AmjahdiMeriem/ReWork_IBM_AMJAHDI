package ma.ibm.DAO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.ibm.modele.Practice;

public class PracticeDAOImpl implements IPracticeDAO{
//--------------------------------------------------------------------------------------------------------------------------//
	public boolean savePractice(Practice practice) {
		EntityTransaction tx = null;
		try {
			EntityManager em = EMF.get().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(practice);
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
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public Map<String, Long> listOfPractices() {
		Map<String,Long> mapOfPractices = new LinkedHashMap<String,Long>();
		EntityManager em = EMF.get().createEntityManager();
		
		String sql="SELECT practice FROM Practice practice";
		Query query=em.createQuery(sql);
		List<Practice> practices = query.getResultList();
		for (int i = 0; i < practices.size(); i++) {
			Long idPractice = practices.get(i).getIdPractice();
			String libPractice = practices.get(i).getLibPractice();
			mapOfPractices.put(libPractice,idPractice);
		}
		if(em.isOpen()) {
			em.close();
		}
		return mapOfPractices;
	}
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Practice> findPracticeAll() {
		EntityManager em=EMF.get().createEntityManager();
		String sql="SELECT p FROM Practice p";
		Query query=em.createQuery(sql);
		return query.getResultList();
	}
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public void deletPractice(Long idPractice) {
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		em.flush();
		em.clear();
		String sql = "DELETE Practice p where p.idPractice=:idPractice";
		Query query = em.createQuery(sql);
		query.setParameter("idPractice", idPractice);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();	
	}
//--------------------------------------------------------------------------------------------------------------------------//
}
