package mainpackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controller {
	
	private Calculator calculator;
	private View view;
	
	public Controller(Calculator calculator, View view)
	{
		this.calculator=calculator;
		this.view=view;
		view.addBisectionListener(new BisectionListener());
		view.addNewtonListener(new NewtonListener());
	}
	public class BisectionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<double[]> result;
			calculator.setTerms(view.getTerms());
			result=calculator.bisection(view.getBX0(), view.getX1(), view.getBIterations(), view.getTolerance());
			view.setBisectionResult(result);
			view.createChart(calculator.BisectionDatasetValues(view.getBX0(), view.getX1(), result), "Graph", view.getChart(), view.getChartPanel(), 12, 18);
		}
	}
	public class NewtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<Double> result;
			calculator.setTerms(view.getTerms());
			result=calculator.newton(view.getNX0(), view.getNIterations());
			view.setNewtonResult(result);
			view.createChart(calculator.NewtonDatasetValues(view.getNX0(), result), "Graph", view.getChart(), view.getChartPanel(), 12, 18);
		}
	}

}
