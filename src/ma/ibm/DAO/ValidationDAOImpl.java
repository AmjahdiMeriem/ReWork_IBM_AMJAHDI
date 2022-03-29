package ma.ibm.DAO;

import javax.persistence.EntityManager;

import ma.ibm.modele.Demande;
import ma.ibm.modele.Statut;

public class ValidationDAOImpl implements IvalidationDAO {
//----------------------------------------------------------------------------------------------------------//
	@Override
	public boolean valider(Long idDemande) {
		Demande demande = new Demande();
		try {
			EntityManager em = EMF.get().createEntityManager();
			demande = em.find(Demande.class, idDemande);
			Long idStatut = demande.getStatut().getIdStatut() + 100L;
			Statut statut=new Statut();
			statut.setIdStatut(idStatut);
			demande.setStatut(statut);
			em.getTransaction().begin();
			em.merge(demande);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;}
	}
//---------------------------------------------------------------------------------------------------------//
	@Override
	public boolean refuser(Long idDemande) {
		Demande demande = new Demande();
		try {
			EntityManager em = EMF.get().createEntityManager();
			demande = em.find(Demande.class, idDemande);
			Long idStatut = demande.getStatut().getIdStatut() + 150L;
			Statut statut=new Statut();
			statut.setIdStatut(idStatut);
			demande.setStatut(statut);
			em.getTransaction().begin();
			em.merge(demande);
			em.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			return false;}
	}
//----------------------------------------------------------------------------------------------------------//
}
