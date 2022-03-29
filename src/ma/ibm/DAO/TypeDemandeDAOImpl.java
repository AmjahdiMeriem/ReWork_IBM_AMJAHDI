package ma.ibm.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ma.ibm.modele.TypeDemande;

public class TypeDemandeDAOImpl implements ITypeDemandeDAO{

	@Override
	public boolean saveTypeDemande(TypeDemande typeDemande) {
		EntityTransaction tx = null;
		
			try {
				EntityManager em = EMF.get().createEntityManager();
				tx = em.getTransaction();
				tx.begin();
				em.persist(typeDemande);
				tx.commit();
				if(em.isOpen()) {
					em.close();
				}
				return true;
			}catch(Exception e) {
				e.printStackTrace();
				tx.rollback();
				return false;}
	}

}
