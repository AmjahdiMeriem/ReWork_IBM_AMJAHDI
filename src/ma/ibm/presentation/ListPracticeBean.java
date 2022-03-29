package ma.ibm.presentation;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ma.ibm.modele.Practice;
import ma.ibm.service.IPracticeService;
import ma.ibm.service.PracticeServiceImpl;

@ManagedBean(name = "listpracticebean")
@ViewScoped
public class ListPracticeBean {

	Practice practice = new Practice();
	Map<String, Long> practiceMap = new LinkedHashMap<String, Long>();
	private IPracticeService ipservice = new PracticeServiceImpl();

	@PostConstruct
	public void init() {
		practiceMap.putAll(ipservice.listOfPractices());
	}

	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	public IPracticeService getIpservice() {
		return ipservice;
	}

	public void setIpservice(IPracticeService ipservice) {
		this.ipservice = ipservice;
	}

	public Map<String, Long> getPracticeMap() {
		return practiceMap;
	}

	public void setPracticeMap(Map<String, Long> practiceMap) {
		this.practiceMap = practiceMap;
	}
}
