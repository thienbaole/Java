package td.play.cs101.queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/* read in large text file, similar to the orders.txt below, 
 order_id, item_id, price 
 101, 6, 17.0836079469882
 106, 5, 12.3865250917152
 105, 4, 10.6771255261265
 106, 5, 17.7769432822242
 102, 5, 10.6416016584262
 103, 4, 11.9245548010804
 ....
 Write a program to print out k biggest orders */

public class PriorityQueueApp {
	static Map&lt;Integer, Order&gt; orderMap = new HashMap&lt;Integer, Order&gt;();

	static PriorityQueue&lt;Order&gt; getTopOrders(String orderFile, int k)
			throws Exception {

		PriorityQueue&lt;Order&gt; topOrders = new PriorityQueue&lt;Order&gt;(k);
		for (int i = 0; i &lt; k; i++) {
			topOrders.add(new Order());
		}

		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(orderFile));
		while ((line = reader.readLine()) != null) {
			OrderItem item = OrderItem.create(line);

			Order order = orderMap.get(item.orderId);
			if (order == null) {
				order = new Order();
			}

			order.addItemToOrder(item);
			orderMap.put(item.orderId, order);
			if (order.total() &gt; topOrders.peek().total()) {
				topOrders.remove();
				topOrders.add(order);
			}
		}
		reader.close();
		return topOrders;
	}

	public static void main(String[] args) throws Exception {
		orderMap.clear();
		String orderFileName = "/Users/thanhdoan/orders.txt";
		PriorityQueue&lt;Order&gt; topOrders = getTopOrders(orderFileName, 3);
		for (Order order : topOrders) {
			System.out.println(order);
		}
	}
}

class OrderItem {
	public static OrderItem create(String line) {
		String token[] = line.split(",");
		OrderItem item = new OrderItem();
		item.orderId = Integer.parseInt(token[0]);
		item.itemID = Integer.parseInt(token[1]);
		item.price = Double.parseDouble(token[2]);
		return item;
	}

	public int orderId;
	public int itemID;
	public double price;
}

class Order implements Comparable&lt;Order&gt; {
	private final LinkedList&lt;OrderItem&gt; items;

	public Order() {
		this.items = new LinkedList&lt;OrderItem&gt;();
	}

	public void addItemToOrder(OrderItem item) {
		items.add(item);
	}

	public double total() {
		double total = 0;
		for (OrderItem item : items) {
			total += item.price;
		}
		return total;
	}

	public int compareTo(Order other) {
		if (this.total() &lt; other.total()) {
			return -1;
		} else if (this.total() == other.total()) {
			return 0;
		} else {
			return 1;
		}
	}

	public String toString() {
		return "Order:" + items.getFirst().orderId + " total:" + total();
	}
}

