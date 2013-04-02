package testspring.testspring;
public class Simulation {

	public void method1(int sleepTime)
	{
		try {
			System.out.println("Method 1 running...");
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void method2(int sleepTime)
	{
		try {
			System.out.println("Method 2 running...");
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
