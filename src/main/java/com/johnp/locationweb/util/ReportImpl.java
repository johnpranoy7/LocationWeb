package com.johnp.locationweb.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Controller;

@Controller
public class ReportImpl implements IReport{

	
	@Override
	public void generatePieChart(String path, List<Object[]> data) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Object[] i : data) {
		dataset.setValue(i[0].toString(), new Double(i[1].toString()));
		}
		JFreeChart createPieChart3D = ChartFactory.createPieChart3D("AreaDistribution", dataset, false, false, false);
		try {
			ChartUtilities.saveChartAsPNG(new File(path+"/piechart.png"), createPieChart3D, 400, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		DefaultPieDataset dataset = new DefaultPieDataset();

		for (Object[] objects : data) {
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
		}

		JFreeChart chart = ChartFactory.createPieChart3D("Location Type Report", dataset);

		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/pieChart.jpeg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}


}
