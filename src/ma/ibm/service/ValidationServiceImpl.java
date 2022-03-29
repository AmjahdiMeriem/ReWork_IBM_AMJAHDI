package ma.ibm.service;

import ma.ibm.DAO.IvalidationDAO;
import ma.ibm.DAO.ValidationDAOImpl;

public class ValidationServiceImpl implements IvalidationService {

	private IvalidationDAO validationDao = new ValidationDAOImpl();
	
//--------------------------------------------------------------------------------------------//
	@Override
	public boolean valider(Long idDemande) {
			return validationDao.valider(idDemande);
	}
//--------------------------------------------------------------------------------------------//
	@Override
	public boolean refuser(Long idDemande) {
		if (validationDao.refuser(idDemande))
			return true;
		else
			return false;
	}
//--------------------------------------------------------------------------------------------//
	public IvalidationDAO getValidationDao() {
		return validationDao;
	}
	public void setValidationDao(IvalidationDAO validationDao) {
		this.validationDao = validationDao;
	}
//-------------------------------------------------------------------------------------------//
}
