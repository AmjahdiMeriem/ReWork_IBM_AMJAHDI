package ma.ibm.service;

import java.util.List;
import java.util.Map;

import ma.ibm.modele.Practice;

public interface IPracticeService {

	public boolean savePractice(Practice practice);
	
	public Map<String,Long> listOfPractices();
	
	public List<Practice> findPracticeAll();
	
	public void deletPractice(Long idPractice);
}
