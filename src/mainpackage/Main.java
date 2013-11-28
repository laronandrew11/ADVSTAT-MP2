package mainpackage;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View view=new View();
		Calculator calculator=new Calculator();
		Controller controller=new Controller(calculator, view);
	}


}
