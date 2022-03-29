package ma.ibm.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.joda.time.LocalDate;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.polar.PolarAreaChartDataSet;
import org.primefaces.model.charts.polar.PolarAreaChartModel;

import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IdemandeService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean
public class ChartJsView2 implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private IdemandeService demandeservice = new DemandeServiceImpl();

	private ITeletravailService teleservice = new TeletravailServiceImpl();

	private PolarAreaChartModel polarAreaModel;

	@PostConstruct
	public void init() {
		createPolarAreaModel();
	}

	private void createPolarAreaModel() {
		polarAreaModel = new PolarAreaChartModel();
		ChartData data = new ChartData();

		PolarAreaChartDataSet dataSet = new PolarAreaChartDataSet();
		List<Number> values = new ArrayList<>();
		int y = LocalDate.now().getYear();
		values.add(demandeservice.findDemandeByTypeYear(2L, y).size());
		values.add(demandeservice.findDemandeByTypeYear(1L, y).size());
		values.add(teleservice.findTeleByTypeYear(1L, y).size());
		values.add(teleservice.findTeleByTypeYear(2L, y).size());
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(255, 99, 132)");
		bgColors.add("rgb(75, 192, 192)");
		bgColors.add("rgb(255, 205, 86)");
		bgColors.add("rgb(201, 203, 207)");
		dataSet.setBackgroundColor(bgColors);

		data.addChartDataSet(dataSet);
		List<String> labels = new ArrayList<>();
		labels.add("Demandes Exc");
		labels.add("Demandes Rec");
		labels.add("Télétravail Rec");
		labels.add("Télétravail Exc");
		data.setLabels(labels);

		polarAreaModel.setData(data);
	}

	public PolarAreaChartModel getPolarAreaModel() {
		return polarAreaModel;
	}

	public void setPolarAreaModel(PolarAreaChartModel polarAreaModel) {
		this.polarAreaModel = polarAreaModel;
	}

	public IdemandeService getDemandeservice() {
		return demandeservice;
	}

	public void setDemandeservice(IdemandeService demandeservice) {
		this.demandeservice = demandeservice;
	}

	public ITeletravailService getTeleservice() {
		return teleservice;
	}

	public void setTeleservice(ITeletravailService teleservice) {
		this.teleservice = teleservice;
	}

}
