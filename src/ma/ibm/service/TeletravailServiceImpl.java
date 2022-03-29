package ma.ibm.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ma.ibm.DAO.ITeletravailDAO;
import ma.ibm.DAO.TeletravailDAOImpl;
import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Teletravail;

public class TeletravailServiceImpl implements ITeletravailService{
	ITeletravailDAO dao=new TeletravailDAOImpl();
	
	@Override
	public void saveTele(Teletravail tele) {
		dao.saveTele(tele);
	}

	@Override
	public List<Teletravail> findTeleByIdCol(Long idCol) {
		return dao.findTeleByIdCol(idCol);
	}

	@Override
	public List<Teletravail> findTeleByMatDel(String matricule) {
		return dao.findTeleByMatDel(matricule);
	}

	@Override
	public List<Teletravail> findTeleByEqui(Long equipe) {
		return dao.findTeleByEqui(equipe);
	}

	@Override
	public Map<String, Double> findTeleByIdColDate(Teletravail tele) {
		Map<String,Double> list=new LinkedHashMap<String, Double>();
		List<Teletravail> t=dao.findTeleByIdColDateType(tele.getDemande().getCol().getIdCol(),2L);
		if(t.size() == 0) {
			list.put("demi-journnée",0.5);
			list.put("une journnée",1.);
			list.put("journnée et demi",1.5);
			list.put("deux journnées",2.);
		}
		else{
			double d=0.;
			for(int i=0;i<t.size();i++) {
				d= d + t.get(i).getDureeTele();
			}
			if(d<=2.) {
				double r=2-d;
				if(r==0.5){
					list.put("demi-journnée",0.5);	
				}
				else if(r==1.) {
					list.put("demi-journnée",0.5);
					list.put("une journnée",1.);
				}
				else if(r==1.5) {
					list.put("Demi-journnée",0.5);
					list.put("Une journnée",1.);
					list.put("Journnée et demi",1.5);}
				else if(r==0.) {
					System.out.println("List null");
					list=null;
				}
			}
		}
		return list;
	}

	@Override
	public List<Teletravail> findall() {
		return dao.findall();
	}

	@Override
	public List<Teletravail> findTeleByTypeYear(Long type,int year) {
		return dao.findTeleByTypeYear(type,year);
	}

	@Override
	public List<Collaborateur> findTeleByInst() {
		
		return dao.findTeleByInst();
	}

}
