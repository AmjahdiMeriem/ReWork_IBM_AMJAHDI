package ma.ibm.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ma.ibm.DAO.IPracticeDAO;
import ma.ibm.DAO.PracticeDAOImpl;
import ma.ibm.modele.Practice;

public class PracticeServiceImpl implements IPracticeService {

	private IPracticeDAO dao=new PracticeDAOImpl();
	
	@Override
	public Map<String, Long> listOfPractices() {
		IPracticeDAO practicedao = new PracticeDAOImpl();
		Map<String, Long> mapOfPractices = new LinkedHashMap<String, Long>();
		mapOfPractices.putAll(practicedao.listOfPractices());
		return mapOfPractices;
	}

	@Override
	public List<Practice> findPracticeAll() {
		return dao.findPracticeAll();
	}

	@Override
	public boolean savePractice(Practice practice) {
		return dao.savePractice(practice);
	}

	@Override
	public void deletPractice(Long idPractice) {
		dao.deletPractice(idPractice);	
	}

}
