package ma.ibm.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.joda.time.LocalDate;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import ma.ibm.modele.Demande;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IdemandeService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean
public class ChartJsView3 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarChartModel b1, b2;
	int max1, max2;
	private IdemandeService demandeservice = new DemandeServiceImpl();
	private ITeletravailService teleservice = new TeletravailServiceImpl();

	@PostConstruct
	public void init() {
		createbarModels();
	}

	private void createbarModels() {
		b1 = initbarModel(1, 1L, LocalDate.now().getYear());
		b2 = initbarModel(1, 2L, LocalDate.now().getYear());
	}

	private BarChartModel initbarModel(int e, Long id, int y) {
		BarChartModel b = new BarChartModel();
		ChartSeries demandes = new ChartSeries();
		demandes.setLabel("Demandes");
		if (e == 1) {
			max1 = demandeservice.findDemandeByTypeYear(id, y).size();
			demandes.set(y, max1);
			for (int i = 1; i < 4; i++) {
				int nbrDem = demandeservice.findDemandeByTypeYear(id, y - i).size();
				demandes.set(y - i, nbrDem);
				if (max1 < nbrDem) {
					max1 = nbrDem;
				}
			}
			b.addSeries(demandes);
			ChartSeries teles = new ChartSeries();
			teles.setLabel("Télétravaux");
			for (int i = 0; i < 4; i++) {
				int nbrTel = teleservice.findTeleByTypeYear(id, y - i).size();
				teles.set(y - i, nbrTel);
				if (max1 < nbrTel) {
					max1 = nbrTel;
				}
			}
			b.addSeries(teles);
		} else if (e == 2) {
			List<Demande> d = demandeservice.findDemandeByTypeYear(id, y);
			int val = 0;
			for (int j = 0; j < d.size(); j++)
				if (d.get(j).getDateDemande().getMonthValue() == 1) {
					val++;
				}
			demandes.set(1, val);
			int max = val;
			for (int i = 2; i <= 12; i++) {
				val = 0;
				for (int j = 0; j < d.size(); j++)
					if (d.get(j).getDateDemande().getMonthValue() == i) {
						val++;
					}
				demandes.set(i, val);
				if (max < val) {
					max = val;
				}
			}
			b.addSeries(demandes);
		} else {
			demandes.setLabel("Télétravaux");
			List<Teletravail> t = teleservice.findTeleByTypeYear(id, y);
			int val = 0;
			for (int j = 0; j < t.size(); j++)
				if (t.get(j).getDateDebut().getMonthValue() == 1) {
					val++;
				}
			demandes.set(1, val);
			int max = val;
			for (int i = 2; i <= 12; i++) {
				val = 0;
				for (int j = 0; j < t.size(); j++)
					if (t.get(j).getDateDebut().getMonthValue() == i) {
						val++;
					}
				demandes.set(i, val);
				if (max < val) {
					max = val;
				}
			}
			b.addSeries(demandes);
		}
		if (id == 2L)
			b.setTitle("Type Exceptionnel");
		else
			b.setTitle("Type Récurrent");
		b.setLegendPosition("ne");
		Axis xAxis = b.getAxis(AxisType.X);
		xAxis.setLabel("  ");
		Axis yAxis = b.getAxis(AxisType.Y);
		yAxis.setLabel(" ");
		yAxis.setMin(0);
		yAxis.setMax(max1 + 5);
		return b;
	}

	public void itemSelect1(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
		int ind = event.getSeriesIndex();
		int item = event.getItemIndex();
		int[] year = { 2019, 2018, 2017, 2016 };
		if (ind == 0) {
			b1 = initbarModel(3, 1L, year[item]);
		} else {
			b1 = initbarModel(2, 1L, year[item]);
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void itemSelect2(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
		int ind = event.getSeriesIndex();
		int item = event.getItemIndex();
		int[] year = { 2019, 2018, 2017, 2016 };
		if (ind == 0) {
			b2 = initbarModel(3, 2L, year[item]);
		} else {
			b2 = initbarModel(2, 2L, year[item]);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public BarChartModel getB1() {
		return b1;
	}

	public BarChartModel getB2() {
		return b2;
	}
}