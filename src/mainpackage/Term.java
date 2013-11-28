package mainpackage;

public class Term {
	
	private double coefficient;
	private int power;
	
	public Term(double coefficient, int power)
	{
		this.coefficient=coefficient;
		this.power=power;
	}
	
	public double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	public double getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}

}
