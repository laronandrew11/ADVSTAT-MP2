package mainpackage;
import java.util.ArrayList;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class Calculator{
	
	ArrayList<Term>terms;
	public Calculator(){
		terms=new ArrayList<Term>();
	}

	public ArrayList<double[]> bisection(double x0, double x1,int max, double tol)
	{
		ArrayList<double[]>values=new ArrayList<double[]>();
		int i=0;
		double y0=f(x0);
		double y1=f(x1);
		double x2;
		double y2;
		do{
			x2=(x0+x1)/2;
			y2=f(x2);
			if(y2!=0)
			{
				if (y1*y2 < 0)
				{
					x0 = x2;
					y0 = y2;
				}
				else 
				{
					x1 = x2;
					y1 = y2;
				}
			}
			values.add(new double[]{x0,x1});
			i++;
		}while(y2!=0&&i<max&&Math.abs(x1-x0)>tol);
		
		return values;
		
	}
	public ArrayList<Double> newton(double x1, int max)
	{	
		ArrayList<Double>values=new ArrayList<Double>();
		double oldx;
		double newx=0;
		oldx=x1;
		for(int i=0;i<max;i++)
		{
			newx=oldx-f(oldx)/fprime(oldx);
			oldx=newx;
			values.add(newx);
		}
		return values;
	}
	
	public ArrayList<double[]>getTrueValues(ArrayList<Double>values)
	{
		ArrayList<double[]>list=new ArrayList<double[]>();
		for(double x1: values)
		{
			list.add(new double[]{x1,f(x1)});
		}
		return list;
	}
	public double f(double x)
	{
		double y=0;
		for(Term t: terms)
		{
			y+=t.getCoefficient()*Math.pow(x, t.getPower());
		}
		return y;
	}
	public double fprime(double x)
	{
		double y=0;
		for(Term t: terms)
		{
			y+=t.getCoefficient()*t.getPower()*Math.pow(x, t.getPower()-1);
		}
		return y;
	}
	
	public void setTerms(ArrayList<Term>terms)
	{
		this.terms=terms;
	}
	public CategoryDataset DatasetValues() {
		DefaultCategoryDataset tempDataset=new DefaultCategoryDataset();
		for(int i = -10; i <= 10; i++)
		{
			tempDataset.addValue(f(i), "Polynomial", Integer.toString(i));
		}
		return tempDataset;
	}
}
