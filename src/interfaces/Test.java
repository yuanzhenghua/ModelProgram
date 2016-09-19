package interfaces;
import interfaces.execute.TestInterfaces;

public class Test {

	public static void main(String[] args) {
		
		try {
			new TestInterfaces().test1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
