package ma.ibm.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.joda.time.LocalDate;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;

import ma.ibm.modele.Collaborateur;
import ma.ibm.modele.Demande;
import ma.ibm.modele.Teletravail;
import ma.ibm.service.DemandeServiceImpl;
import ma.ibm.service.ITeletravailService;
import ma.ibm.service.IdemandeService;
import ma.ibm.service.TeletravailServiceImpl;

@ManagedBean(name = "dashboardbean")
public class DashBoardBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BarChartModel barModel1;
	private BarChartModel barModel2;
	private BarChartModel barModel3;
	private BarChartModel barModel4;
	private BarChartModel barModel5;
	private BarChartModel barModel6;
	private BarChartModel barModel7;
	private BarChartModel barModel8;
	private BarChartModel barModel9;
	private BarChartModel barModel10;
	private BarChartModel barModel11;
	private BarChartModel barModel12;
	private Demande demande = new Demande();
	private List<Demande> demandes = new ArrayList<Demande>();
	private IdemandeService demandeservice = new DemandeServiceImpl();
	private Collaborateur col = new Collaborateur();
	private List<Teletravail> tele = new ArrayList<Teletravail>();
	private ITeletravailService teleservice = new TeletravailServiceImpl();

	@PostConstruct
	public void init() {

		createBarModel1();
		createBarModel2();
		createBarModel3();
		createBarModel4();
		createBarModel5();
		createBarModel6();
		createBarModel7();
		createBarModel8();
		createBarModel9();
		createBarModel10();
		createBarModel11();
		createBarModel12();
	}

	public void createBarModel1() {

		barModel1 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		int y = LocalDate.now().getYear();
		barDataSet.setLabel("Nombre de demandes exceptionneles en " + y);
		List<Number> values = new ArrayList<>();
		demandes = demandeservice.findDemandeByTypeYear(2L, y);

		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < demandes.size(); j++)
				if (demandes.get(j).getDateDemande().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel1.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel1.setOptions(options);
	}

	public void createBarModel2() {

		barModel2 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		int y = LocalDate.now().getYear();
		barDataSet.setLabel("Nombre de demandes récurrentes en " + y);
		List<Number> values = new ArrayList<>();
		demandes = demandeservice.findDemandeByTypeYear(1L, y);

		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < demandes.size(); j++)
				if (demandes.get(j).getDateDemande().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel2.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel2.setOptions(options);
	}

	public void createBarModel3() {
		barModel3 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		col = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		int y = LocalDate.now().getYear();
		barDataSet.setLabel("Nombre de demandes exceptionnels de mon équipe en " + y);
		List<Number> values = new ArrayList<>();
		demandes = demandeservice.findDemandeByEquiTypeYear(col.getEquipe().getIdEquipe(), 2L, y);
		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < demandes.size(); j++)
				if (demandes.get(j).getDateDemande().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel3.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel3.setOptions(options);
	}

	public void createBarModel4() {

		barModel4 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		col = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		int y = LocalDate.now().getYear();
		barDataSet.setLabel("Nombre de demandes récurrentes de mon équipe en " + y);
		List<Number> values = new ArrayList<>();
		demandes = demandeservice.findDemandeByEquiTypeYear(col.getEquipe().getIdEquipe(), 1L, y);
		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < demandes.size(); j++)
				if (demandes.get(j).getDateDemande().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel4.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel4.setOptions(options);
	}

	public void createBarModel5() {

		barModel5 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Nombre de télétravaux récurrents en " + LocalDate.now().getYear());
		List<Number> values = new ArrayList<>();
		tele = teleservice.findTeleByTypeYear(1L, LocalDate.now().getYear());
		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < tele.size(); j++)
				if (tele.get(j).getDateDebut().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel5.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel5.setOptions(options);
	}

	public void createBarModel6() {

		barModel6 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Nombre de télétravaux exceptionnels en " + LocalDate.now().getYear());
		List<Number> values = new ArrayList<>();
		tele = teleservice.findTeleByTypeYear(2L, LocalDate.now().getYear());
		if (tele.size() > 0) {
			for (int i = 1; i <= 12; i++) {
				int val = 0;
				for (int j = 0; j < tele.size(); j++) {
					if (tele.get(j).getDateDebut().getMonthValue() == i) {
						val++;
					}
				}
				values.add(val);
			}
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel6.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel6.setOptions(options);
	}

	public void createBarModel7() {
		barModel7 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		col = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		int y = LocalDate.now().getYear();
		barDataSet.setLabel("Nombre de demandes exceptionnels de mon équipe en " + y);
		List<Number> values = new ArrayList<>();
		demandes = demandeservice.findDemandeByMatDelTypeYear(col.getMatriculeCol(), 2L, y);
		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < demandes.size(); j++)
				if (demandes.get(j).getDateDemande().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel7.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel7.setOptions(options);
	}

	public void createBarModel8() {

		barModel8 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		col = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		int y = LocalDate.now().getYear();
		barDataSet.setLabel("Nombre de demandes récurrentes de mon équipe en " + y);
		List<Number> values = new ArrayList<>();
		demandes = demandeservice.findDemandeByMatDelTypeYear(col.getMatriculeCol(), 1L, y);
		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < demandes.size(); j++)
				if (demandes.get(j).getDateDemande().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel8.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel8.setOptions(options);
	}

	public void createBarModel9() {

		barModel9 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Nombre des demandes récurrentes");
		List<Number> values = new ArrayList<>();
		demandes = demandeservice.findAllDemandeType(1L);
		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < demandes.size(); j++)
				if (demandes.get(j).getDateDemande().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel9.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel9.setOptions(options);
	}

	public void createBarModel10() {

		barModel10 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Nombre des demandes exceptionneles");
		List<Number> values = new ArrayList<>();
		demandes = demandeservice.findAllDemandeType(2L);
		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < demandes.size(); j++)
				if (demandes.get(j).getDateDemande().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel10.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel10.setOptions(options);
	}

	public void createBarModel11() {

		barModel11 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		LocalDate y = new LocalDate();
		col = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		barDataSet.setLabel("Nombre des télétravaux exceptionnels de mon équipe en " + y);
		List<Number> values = new ArrayList<>();
		tele = teleservice.findTeleByMatDel(col.getMatriculeCol());
		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < tele.size(); j++)
				if (tele.get(j).getDateDebut().getYear() == y.getYear()
						&& tele.get(j).getDateDebut().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel11.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel11.setOptions(options);
	}

	public void createBarModel12() {

		barModel12 = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		LocalDate y = new LocalDate();
		col = (Collaborateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("col");
		barDataSet.setLabel("Nombre des télétrvaux récurrents de mon équipe en " + y);
		List<Number> values = new ArrayList<>();
		tele = teleservice.findTeleByMatDel(col.getMatriculeCol());
		for (int i = 1; i <= 12; i++) {
			int val = 0;
			for (int j = 0; j < tele.size(); j++)
				if (tele.get(j).getDateDebut().getYear() == y.getYear()
						&& tele.get(j).getDateDebut().getMonthValue() == i) {
					val++;
				}
			values.add(val);
		}

		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 103, 207, 0.2)");
		bgColor.add("rgba(211, 03, 220, 0.2)");
		bgColor.add("rgba(11, 253, 175, 0.2)");
		bgColor.add("rgba(141, 69, 148, 0.2)");
		bgColor.add("rgba(255, 22, 148, 0.2)");
		bgColor.add("rgba(22, 180, 255, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgba(211, 03, 220)");
		borderColor.add("rgba(11, 253, 175");
		borderColor.add("rgba(141, 69, 148)");
		borderColor.add("rgba(255, 22, 148)");
		borderColor.add("rgba(22, 180, 255)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel12.setData(data);

		// Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(false);
		title.setText("Graphe télétravail");
		// options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel12.setOptions(options);
	}

	public BarChartModel getBarModel2() {
		return barModel2;
	}

	public void setBarModel2(BarChartModel barModel2) {
		this.barModel2 = barModel2;
	}

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public IdemandeService getDemandeservice() {
		return demandeservice;
	}

	public void setDemandeservice(IdemandeService demandeservice) {
		this.demandeservice = demandeservice;
	}

	public BarChartModel getBarModel3() {
		return barModel3;
	}

	public void setBarModel3(BarChartModel barModel3) {
		this.barModel3 = barModel3;
	}

	public BarChartModel getBarModel4() {
		return barModel4;
	}

	public void setBarModel4(BarChartModel barModel4) {
		this.barModel4 = barModel4;
	}

	public Collaborateur getCol() {
		return col;
	}

	public void setCol(Collaborateur col) {
		this.col = col;
	}

	public BarChartModel getBarModel1() {
		return barModel1;
	}

	public void setBarModel1(BarChartModel barModel1) {
		this.barModel1 = barModel1;
	}

	public BarChartModel getBarModel5() {
		return barModel5;
	}

	public void setBarModel5(BarChartModel barModel5) {
		this.barModel5 = barModel5;
	}

	public BarChartModel getBarModel6() {
		return barModel6;
	}

	public void setBarModel6(BarChartModel barModel6) {
		this.barModel6 = barModel6;
	}

	public BarChartModel getBarModel7() {
		return barModel7;
	}

	public void setBarModel7(BarChartModel barModel7) {
		this.barModel7 = barModel7;
	}

	public BarChartModel getBarModel8() {
		return barModel8;
	}

	public void setBarModel8(BarChartModel barModel8) {
		this.barModel8 = barModel8;
	}

	public BarChartModel getBarModel9() {
		return barModel9;
	}

	public void setBarModel9(BarChartModel barModel9) {
		this.barModel9 = barModel9;
	}

	public BarChartModel getBarModel10() {
		return barModel10;
	}

	public void setBarModel10(BarChartModel barModel10) {
		this.barModel10 = barModel10;
	}

	public BarChartModel getBarModel11() {
		return barModel11;
	}

	public void setBarModel11(BarChartModel barModel11) {
		this.barModel11 = barModel11;
	}

	public BarChartModel getBarModel12() {
		return barModel12;
	}

	public void setBarModel12(BarChartModel barModel12) {
		this.barModel12 = barModel12;
	}

}