package ma.ibm.presentation;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

import ma.ibm.modele.Demande;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IdemandeService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean
public class ChartJsView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Demande> demandes = new ArrayList<Demande>();
	private IdemandeService demandeservice = new DemandeServiceImpl();

	private List<Teletravail> tele = new ArrayList<Teletravail>();
	private ITeletravailService teleservice = new TeletravailServiceImpl();

	private LineChartModel cartesianLinerModel;

	@PostConstruct
	public void init() {
		createCartesianLinerModel();
	}

	public void createCartesianLinerModel() {
		cartesianLinerModel = new LineChartModel();
		ChartData data = new ChartData();

		LineChartDataSet dataSet = new LineChartDataSet();
		List<Number> values = new ArrayList<>();
		int y = LocalDate.now().getYear();
		int m = LocalDate.now().getMonthValue();
		demandes = demandeservice.findDemandeByTypeYear(1L, y);
		for (int i = 1; i <= m; i++) {
			int val = 0;
			for (int j = 0; j < demandes.size(); j++)
				if (demandes.get(j).getDateDemande().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}
		dataSet.setData(values);
		dataSet.setLabel("Demandes récurrentes");
		dataSet.setBorderColor("rgb(75, 192, 192)");
		dataSet.setYaxisID("left-y-axis");

		LineChartDataSet dataSet2 = new LineChartDataSet();
		List<Number> values2 = new ArrayList<>();
		tele = teleservice.findTeleByTypeYear(1L, LocalDate.now().getYear());
		for (int i = 1; i <= m; i++) {
			int val = 0;
			for (int j = 0; j < tele.size(); j++)
				if (tele.get(j).getDateDebut().getMonthValue() == i) {
					val++;
				}
			values2.add(val);
		}
		dataSet2.setData(values2);
		dataSet2.setLabel("Télétravaux récurrents");
		dataSet2.setBorderColor("rgb(175, 92, 92)");
		dataSet2.setYaxisID("right-y-axis");

		data.addChartDataSet(dataSet);
		data.addChartDataSet(dataSet2);

		List<String> labels = new ArrayList<>();
		labels.add("Jan");
		labels.add("Feb");
		labels.add("Mar");
		labels.add("Apr");
		labels.add("May");
		labels.add("Jun");
		labels.add("Jui");
		labels.add("Aou");
		labels.add("Sept");
		labels.add("Oct");
		labels.add("Nov");
		labels.add("Déc");
		List<String> mois = new ArrayList<String>();
		for (int i = 0; i <= m; i++) {
			mois.add(labels.get(i));
		}
		data.setLabels(mois);
		cartesianLinerModel.setData(data);

		// Options
		LineChartOptions options = new LineChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		linearAxes.setId("left-y-axis");
		linearAxes.setPosition("left");
		CartesianLinearAxes linearAxes2 = new CartesianLinearAxes();
		linearAxes2.setId("right-y-axis");
		linearAxes2.setPosition("right");

		cScales.addYAxesData(linearAxes);
		cScales.addYAxesData(linearAxes2);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(true);
		title.setText(" Statistiques de l'année 2019 ");
		options.setTitle(title);

		cartesianLinerModel.setOptions(options);
	}

	public LineChartModel getCartesianLinerModel() {
		return cartesianLinerModel;
	}

	public void setCartesianLinerModel(LineChartModel cartesianLinerModel) {
		this.cartesianLinerModel = cartesianLinerModel;
	}

}
