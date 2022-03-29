package ma.ibm.DAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Teletravail;

public class TeletravailDAOImpl implements ITeletravailDAO {

	@Override
	public void saveTele(Teletravail tele) {
		EntityTransaction tx = null;
		tele.setDateDebut(LocalDate.now());
		EntityManager em = EMF.get().createEntityManager();
		try {

			tx = em.getTransaction();
			tx.begin();
			em.persist(tele);
			tx.commit();
			if (em.isOpen()) {
				em.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public List<Teletravail> findTeleByIdCol(Long idCol) {
		EntityManager em = EMF.get().createEntityManager();
		List<Teletravail> results = new ArrayList<Teletravail>();
		String sql = "SELECT dI FROM Teletravail dI where dI.demande.col.idCol=:idCol";
		Query query = em.createQuery(sql);
		query.setParameter("idCol", idCol);
		results = query.getResultList();
		return results;
	}

	@Override
	public List<Teletravail> findTeleByMatDel(String matricule) {
		EntityManager em = EMF.get().createEntityManager();
		List<Teletravail> results = new ArrayList<Teletravail>();
		String sql = "SELECT dI FROM Teletravail dI where dI.demande.matriculeDelivery=:matriculeDelivery";
		Query query = em.createQuery(sql);
		query.setParameter("matriculeDelivery", matricule);
		results = query.getResultList();

		return results;
	}

	@Override
	public List<Teletravail> findTeleByEqui(Long equipe) {
		EntityManager em = EMF.get().createEntityManager();
		List<Teletravail> results = new ArrayList<Teletravail>();
		String sql = "SELECT dI FROM Teletravail dI where dI.demande.col.equipe.idEquipe=:equipe";
		Query query = em.createQuery(sql);
		query.setParameter("equipe", equipe);
		results = query.getResultList();

		return results;
	}

	@Override
	public List<Teletravail> findTeleByIdColDateType(Long idCol, Long type) {
		EntityManager em = EMF.get().createEntityManager();
		List<Teletravail> results = new ArrayList<Teletravail>();
		results = null;
		LocalDate t = LocalDate.now();
		int month = t.getMonthValue();
		int year = t.getYear();
		String sql = "SELECT dI FROM Teletravail dI where dI.demande.col.idCol=:id and month(dI.dateDebut)=:month and year(dI.dateDebut)=:year"
				+ " and dI.demande.typeDemande.idTypeDemande=:type";
		Query query = em.createQuery(sql);
		query.setParameter("id", idCol);
		query.setParameter("month", month);
		query.setParameter("year", year);
		query.setParameter("type", type);
		results = query.getResultList();
		return results;
	}

	@Override
	public List<Teletravail> findall() {
		EntityManager em = EMF.get().createEntityManager();
		List<Teletravail> results = new ArrayList<Teletravail>();
		String sql = "SELECT dI FROM Teletravail dI";
		Query query = em.createQuery(sql);
		results = query.getResultList();
		return results;
	}

	@Override
	public List<Teletravail> findTeleByTypeYear(Long type, int year) {

		EntityManager em = EMF.get().createEntityManager();
		List<Teletravail> results = new ArrayList<Teletravail>();
		String sql = "SELECT dI FROM Teletravail dI where dI.demande.typeDemande.idTypeDemande=:type and year(dI.dateDebut)=:year";
		Query query = em.createQuery(sql);
		query.setParameter("type", type);
		query.setParameter("year", year);
		results = query.getResultList();
		return results;
	}

	@Override
	public List<Collaborateur> findTeleByInst() {

		EntityManager em = EMF.get().createEntityManager();
		
		try {
			String d=LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE",Locale.FRENCH));
			String sql = "SELECT c FROM Teletravail t, Demande d, Collaborateur c where t.demande.idDemande = d.idDemande"
					+ " and :today >= t.dateDebut and d.col.idCol = c.idCol and LOWER(:dayOfWeek) = LOWER(d.jourTele)";
			Query query = em.createQuery(sql);
			query.setParameter("today", LocalDate.now());
			query.setParameter("dayOfWeek", d);
			List<Collaborateur> colls = query.getResultList();
			return colls;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

}
