package ma.ibm.DAO;

import ma.ibm.modele.Collaborateur;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.persistence.*;

public class LoginDAOImpl implements ILoginDAO {
//--------------------------------------------------------------------------------------------------------------------------//
	public Collaborateur checkLogin(Collaborateur col) throws UnsupportedEncodingException {
		EntityManager em = EMF.get().createEntityManager();

		String login = col.getLogin();
		login = LoginCrypt.loginHash(login);
		
		String password = col.getPassword();
		password = LoginCrypt.passHash(password);

		String sql = "select col FROM Collaborateur col WHERE col.login=:login and col.password=:password";
		Query query = em.createQuery(sql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		List results = query.getResultList();
        if (results.isEmpty()) 
        	
        return null;
        else if (results.size() == 1) 
        {
        	col= (Collaborateur) results.get(0);
        	return col; 
        }
        throw new NonUniqueResultException();
	}
//--------------------------------------------------------------------------------------------------------------------------//
}
