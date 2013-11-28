package mainpackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
			double[] result;
			calculator.setTerms(view.getTerms());
			result=calculator.bisection(view.getBX0(), view.getX1(), view.getBIterations(), view.getTolerance());
			view.setBisectionResult(result);
			
		}
	}
	public class NewtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			double result;
			calculator.setTerms(view.getTerms());
			result=calculator.newton(view.getNX0(), view.getNIterations());
			view.setNewtonResult(result);
			
		}
	}

}
