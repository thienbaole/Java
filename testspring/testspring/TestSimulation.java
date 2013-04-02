package testspring.testspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestSimulation {

	public static void main(String args[])
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("simulation.xml");
		//System.out.println("test!");
		Simulation sim = (Simulation) context.getBean("simulation");
		sim.method1(100);
	}
}
