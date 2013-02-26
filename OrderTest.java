import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;


public class OrderTest {
	private long numOfTopOrders=0;
	private PriorityQueue<Order> topOrders;//= new PriorityQueue<Order>();
	private HashMap<Long,Order> orders = new HashMap<Long,Order>();

	public void readOrders(String filename) throws Exception
	{
		BufferedReader buff = new BufferedReader(new FileReader(filename));
		String line;
		while ( (line=buff.readLine()) != null)
		{
			String[] tokens = line.split(",");
			OrderItem item = new OrderItem(Long.valueOf(tokens[1]).longValue(), Double.valueOf(tokens[2]).doubleValue());
			Order order = orders.get(Long.valueOf(tokens[0]));
			if (topOrders.contains(order))
			{
				topOrders.remove(order);
			}

			if (order != null)
			{
				order.add(item);
			}
			else
			{
				order = new Order(Long.valueOf(tokens[0]).longValue(), item);
				orders.put(Long.valueOf(tokens[0]), order);
			}
			
			if (topOrders.size() < numOfTopOrders)
			{
				topOrders.add(order);
			}
			else if (topOrders.peek().totalPrice() < order.totalPrice())
			{
				topOrders.remove();
				topOrders.add(order);		
			}
		}
		
	}
	public void getTopOrders(int top)
	{
		numOfTopOrders = top;
		//Comparator<Order> priceComparator = new OrderComparator();
		try {
			topOrders = new PriorityQueue<Order>(top);
			readOrders("C:\\Users\\thien-le\\workspace\\TestJava\\src\\orderitems.txt");
			while(topOrders.size() > 0)
			{
				System.out.println(topOrders.remove());
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage().toString());
		}
	}
	public static void main(String args[])
	{
		OrderTest test = new OrderTest();
		test.getTopOrders(3);
	}
}

class Order implements Comparable<Order> {
	private long orderId;
	private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	public Order(long id, OrderItem item)
	{
		orderId = id;
		orderItems.add(item);
	}

	public void add(OrderItem item) {
		// TODO Auto-generated method stub
		orderItems.add(item);
	}
	public int compareTo(Order e)
	{
		if (totalPrice() > e.totalPrice())
			return 1;
		else if (totalPrice() == e.totalPrice() )
			return 0;
		else return -1;
	}

	public double totalPrice() {
		double price = 0;
		// TODO Auto-generated method stub
		for (int i=0; i<orderItems.size(); i++)
			price += orderItems.get(i).getPrice();
		return price;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Order ID:" + this.orderId);
		System.out.println("Total Price:" + this.totalPrice());
	}
	
	public String toString()
	{
			return "Order ID: " +this.orderId + "\nTotal price: " + this.totalPrice();
		
	}
	public boolean equals(Order o)
	{
		if (this.orderId == o.orderId)
			return true;
		else
			return false;
	}
	
}

class OrderItem {
	private long orderItemId;
	private double price;
	

	public OrderItem(long morderItemId, double mprice)
	{
		this.orderItemId = morderItemId;
		this.price = mprice;
	}


	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}
