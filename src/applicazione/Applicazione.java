package applicazione;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import applicazione.store.Customer;
import applicazione.store.Order;
import applicazione.store.Product;

public class Applicazione {
	public static void main(String[] args) {
		Product p1 = new Product("Orbea Alma M50", "Books", 109);
		Product p2 = new Product("BMC Twostroke 01", "Baby", 129);
		Product p3 = new Product("Cannondale Scalpel HT", "Boys", 59);
		Product p4 = new Product("Olympia F1", "Baby", 169);
		Product p5 = new Product("Scott Scale 930", "Books", 125);
		Product p6 = new Product("Rockrider RACE 900", "Baby", 99);
		Product p7 = new Product("Canyon Exceed CF7", "Boys", 159);
		Product p8 = new Product("Wilier Triestina USMA-SLR", "Boys", 299);
		Product p9 = new Product("Specialized Epic HT", "Boys", 359);

		List<Product> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		list.add(p8);
		list.add(p9);

		List<Product> listMoreThan100 = list.stream()
				.filter(book -> book.getPrice() > 100 && book.getCategory().toString().equals("Books")).toList();

		System.out.println("Esercizio 1 " + listMoreThan100);

		Customer c1 = new Customer("Ajeje", 1);
		Customer c2 = new Customer("Rezzonico", 2);
		Customer c3 = new Customer("Brutto", 2);

		List<Product> babyListC1 = list.stream()
				.filter(baby -> baby.getPrice() < 100 && baby.getCategory().toString().equals("Baby")).toList();
		List<Product> babyListC2 = list.stream()
				.filter(baby -> baby.getPrice() > 100 && baby.getCategory().toString().equals("Baby")).toList();
		List<Product> babyListC3 = list.stream().filter(
				baby -> baby.getName().equals("BMC Twostroke 01") && baby.getCategory().toString().equals("Baby"))
				.toList();

		LocalDate date1 = LocalDate.of(2021, 2, 28);
		LocalDate date2 = LocalDate.of(2021, 3, 15);

		Order o1 = new Order("ricevuto", date1, babyListC1, c1);
		Order o2 = new Order("in lavorazione", babyListC2, c2);
		Order o3 = new Order("spedito", date2, babyListC3, c3);

		List<Order> orders = new ArrayList<>();
		orders.add(o1);
		orders.add(o2);
		orders.add(o3);

		System.out.println("Esercizio 2 " + orders);

		List<Product> boysList = list.stream().filter(boys -> boys.getCategory().toString().equals("Boys"))
				.map(boys -> {
					boys.setPrice(Math.round(boys.getPrice() * 0.90));
					return boys;
				}).toList();

		System.out.println("Esercizio 3 " + boysList);

		List<List<Product>> februaryToAprilList = orders.stream()
				.filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31))
						&& order.getOrderDate().isBefore(LocalDate.of(2021, 5, 1))
						&& order.getCustomer().getTier() == 2)
				.map(order -> order.getProducts()).toList();

		System.out.println("Esercizio 4 " + februaryToAprilList);
	}
}
