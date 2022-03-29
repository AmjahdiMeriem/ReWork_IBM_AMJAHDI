package ma.ibm.service;

import java.io.UnsupportedEncodingException;

import ma.ibm.DAO.ILoginDAO;
import ma.ibm.DAO.LoginDAOImpl;
import ma.ibm.modele.Collaborateur;

public class LoginServiceImpl implements IloginService {
	ILoginDAO logdao = new LoginDAOImpl();
//---------------------------------------------------------------------------------------------------------------------------//
	@Override
	public Collaborateur checkLogin(Collaborateur col) throws UnsupportedEncodingException {
		return logdao.checkLogin(col);
	}
//--------------------------------------------------------------------------------------------------------------------------//
	public ILoginDAO getLogdao() {
		return logdao;
	}
	public void setLogdao(ILoginDAO logdao) {
		this.logdao = logdao;
	}
//-------------------------------------------------------------------------------------------------------------------------//
}
