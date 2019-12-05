package _ES._ES;
import javax.swing.JPanel;
import javax.swing.table.TableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends JPanel {

	private TableModel tableModel;
	private String chartTitle;

	public PieChart(TableModel tableModel, String chartTitle, int column) {
		this.tableModel = tableModel;
		this.chartTitle = chartTitle;

		PieDataset dataset = createDataset(column);
		// based on the dataset we create the chart
		JFreeChart chart = createChart(dataset, chartTitle);
		// we put the chart into a panel
		ChartPanel chartPanel = new ChartPanel(chart);
		// default size
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));


		this.add(chartPanel);

	}


	private PieDataset createDataset(int column) {

		int rows = tableModel.getRowCount();

		double counter = 0;
		for (int i = 0; i < rows; i++) {


			Object object = tableModel.getValueAt(i, column);

			if(object instanceof String) {
				String value = (String) object;
				System.out.println("Vou converter: |"+value+"|");
				
				boolean bool = Boolean.parseBoolean(value);
				
				if(bool == true) {
					counter++;
				}

			}

		}

		double acertos = counter / rows;
		double erros = (rows - counter) / rows;

		System.out.println(chartTitle + ": Acertos = " + acertos + "%, Erros = " + erros + "%");


		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("Acertos", acertos);
		result.setValue("Erros", erros);
		return result;

	}

	private JFreeChart createChart(PieDataset dataset, String title) {

		JFreeChart chart = ChartFactory.createPieChart3D(
				title,                  // chart title
				dataset,                // data
				true,                   // include legend
				true,
				false
				);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;

	}

}