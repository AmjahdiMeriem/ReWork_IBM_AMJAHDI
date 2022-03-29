package ma.ibm.DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ma.ibm.modele.Demande;
public class DemandeDaoImpl implements IdemandeDAO {
//---------------------------------------------------------------------------------------------------------------------------//
	@Override
	public boolean saveDemande(Demande demande) {
		EntityTransaction tx = null;
		demande.setDateDemande(LocalDate.now());
			try {
				EntityManager em = EMF.get().createEntityManager();
				tx = em.getTransaction();
				tx.begin();
				em.persist(demande);
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
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByIdCol(Long idCol) {
		EntityManager em = EMF.get().createEntityManager();
		String sql="SELECT dI FROM Demande dI where dI.col.idCol=:id";
		Query query=em.createQuery(sql);
		query.setParameter("id",idCol);
		List<Demande> demandes = query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//---------------------------------------------------------------------------------------------------------------------------//	
	@Override
	public List<Demande> findDemandeByStatutMatDel(Long idStatut,String matricule) {
		EntityManager em = EMF.get().createEntityManager();
		String sql="SELECT dS FROM Demande dS where dS.statut.idStatut=:idStatut and dS.matriculeDelivery=:matricule";
		Query query=em.createQuery(sql);
		query.setParameter("idStatut",idStatut);
		query.setParameter("matricule",matricule);
		List<Demande> demandes = query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//----------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByMatDel(String matriculeDel) {
		EntityManager em = EMF.get().createEntityManager();
		String sql="SELECT dS FROM Demande dS where dS.matriculeDelivery=:matricule";
		Query query=em.createQuery(sql);
		query.setParameter("matricule",matriculeDel);
		List<Demande> demandes = query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//----------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByEqui(Long equipe) {
		EntityManager em = EMF.get().createEntityManager();
		String sql="SELECT d FROM Demande d where d.col.equipe.idEquipe=:equipe";
		Query query=em.createQuery(sql);
		query.setParameter("equipe",equipe);
		List<Demande> demandes = query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//----------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByStatutEqui(Long idStatut,Long equipe) {
		EntityManager em = EMF.get().createEntityManager();
		String sql="SELECT dS FROM Demande dS where dS.statut.idStatut=:idStatut and dS.col.equipe.idEquipe=:equipe and dS.typeDemande.idTypeDemande =:idTypeDemande";
		Query query=em.createQuery(sql);
		query.setParameter("idStatut",idStatut);
		query.setParameter("equipe",equipe);
		query.setParameter("idTypeDemande",1L);
		List<Demande> demandes = query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByStatutMatCol(Long idStatut, String matricule) {
		EntityManager em = EMF.get().createEntityManager();
		String sql="SELECT dS FROM Demande dS where dS.statut.idStatut=:idStatut and dS.col.matriculeCol=:matricule";
		Query query=em.createQuery(sql);
		query.setParameter("idStatut",idStatut);
		query.setParameter("matricule",matricule);
		List<Demande> demandes = query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public Demande findDemandeByIdDemande(Long idDemande) {
		EntityManager em = EMF.get().createEntityManager();
		Demande demande;
		String sql="SELECT d FROM Demande d where d.idDemande=:idDemande";
		Query query=em.createQuery(sql);
		query.setParameter("idDemande",idDemande);
		List results = query.getResultList();
        if (results.isEmpty()) {
        	if(em.isOpen()) {
				em.close();
			}
        return null;}
        else if (results.size() == 1) 
        {
        	demande = (Demande) results.get(0);
        	if(em.isOpen()) {
				em.close();
			}
        	return demande; 
        }
        throw new NonUniqueResultException();
	}
//----------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findAllDemande()
	{
		EntityManager em = EMF.get().createEntityManager();
		String sql="SELECT dS FROM Demande dS";
		Query query=em.createQuery(sql);
		List<Demande> demandes = query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//----------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByTypeYear(Long type,int year) {
		EntityManager em=EMF.get().createEntityManager();
		String sql="SELECT d FROM Demande d where d.typeDemande.idTypeDemande=:type and year(d.dateDemande)=:y";
		Query query=em.createQuery(sql);
		query.setParameter("type", type);
		query.setParameter("y", year);
		List<Demande> demandes =query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//----------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByEquiTypeYear(Long equipe,Long type,int year) {
		EntityManager em = EMF.get().createEntityManager();
		String sql="SELECT dS FROM Demande dS where dS.col.equipe.idEquipe=:equipe and dS.typeDemande.idTypeDemande=:type and year(dS.dateDemande)=:y";
		Query query=em.createQuery(sql);
		query.setParameter("equipe",equipe);
		query.setParameter("type",type);
		query.setParameter("y",year);
		List<Demande> demandes = query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//--------------------------------------------------------------------------------------------------------------------------//
	@Override
	public List<Demande> findDemandeByMatDelTypeYear(String matriculeDel, Long type, int year) {
		EntityManager em = EMF.get().createEntityManager();
		String sql="SELECT dS FROM Demande dS where dS.matriculeDelivery=:matricule and dS.typeDemande.idTypeDemande=:type and year(dS.dateDemande)=:y";
		Query query=em.createQuery(sql);
		query.setParameter("matricule",matriculeDel);
		query.setParameter("type",type);
		query.setParameter("y",year);
		List<Demande> demandes = query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
//--------------------------------------------------------------------------------------------------------------------------//	
	@Override
	public List<Demande> findAllDemandeType(Long type) {
		EntityManager em=EMF.get().createEntityManager();
		String sql="SELECT d FROM Demande d where d.typeDemande.idTypeDemande=:type";
		Query query=em.createQuery(sql);
		query.setParameter("type",type);
		List<Demande> demandes=query.getResultList();
		if(em.isOpen()) {
			em.close();
		}
		return demandes;
	}
}

