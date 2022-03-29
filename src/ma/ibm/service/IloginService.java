package ma.ibm.service;

import java.io.UnsupportedEncodingException;

import ma.ibm.modele.Collaborateur;

public interface IloginService {

	public Collaborateur checkLogin(Collaborateur colab) throws UnsupportedEncodingException;
}
