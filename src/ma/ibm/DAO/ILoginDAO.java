package ma.ibm.DAO;

import java.io.UnsupportedEncodingException;

import ma.ibm.modele.Collaborateur;

public interface ILoginDAO {
	
	public Collaborateur checkLogin(Collaborateur colab) throws UnsupportedEncodingException;

}
