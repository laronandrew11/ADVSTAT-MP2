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
			if(view.getBX0() != view.getX1()) {
				
				calculator.setTerms(view.getTerms());
				result=calculator.bisection(view.getBX0(), view.getX1(), view.getBIterations(), view.getTolerance());
				if(calculator.f(view.getBX0()) * calculator.f(view.getX1()) <= 0) {
					view.setBisectionResult(result);
					view.createChart(calculator.BisectionDatasetValues(view.getBX0(), view.getX1(), result), "Graph", view.getChart(), view.getChartPanel(), 12, 18);
				}
				else view.displayError("f(x0)*f(x1) cannot be greater than 0");
			}
			else view.displayError("x0 and x1 cannot have the same value");
		}
	}
	public class NewtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<double[]> result;
			if(view.getNX0()!=0)
			{
				calculator.setTerms(view.getTerms());
				result=calculator.newton(view.getNX0(), view.getNIterations()/*,view.getNTolerance()*/);
				view.setNewtonResult(result);
				view.createChart(calculator.NewtonDatasetValues(view.getNX0(), result), "Graph", view.getChart(), view.getChartPanel(), 12, 18);
		
			}
			else view.displayError("Initial value cannot be 0");
		}
	}

}
