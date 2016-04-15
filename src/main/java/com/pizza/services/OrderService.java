package com.pizza.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import com.pizza.model.CreditCard;
import com.pizza.model.Item;
import com.pizza.model.Orders;
import com.pizza.model.Pizza;
import com.pizza.model.User;
import com.pizza.repository.CreditCardRepository;
import com.pizza.repository.ItemRepository;
import com.pizza.repository.OrdersRepository;
import com.pizza.repository.PizzaRepository;
import com.pizza.repository.UserRepository;

/*
 * This is service class where all repository calls can will be made.
 * This is done in this way as in controller only request receiving and 
 * response sending back operations has to be done
 */
public class OrderService {
	
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	PizzaRepository pizzaRepository;
	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CreditCardRepository creditCardRepository;
	
	/*
	 * @description: This method is used to create order by parsing json data . 
	 * This method should can be more modified to manage session so that any error will not make our database obsoloete
	 * @Params
	 * JSON data received by order create rest call, This data is received in hashamp way to access it 
	 * easily using Java data structures
	 * @Returns: Return orders object which is create this can be null if any error or data received from 
	 * json is not incomplete.
	 */
	public Orders createService(HashMap<String, Object> jsonData){
		Orders order = new Orders();
		if(jsonData.get("pizzaList") != null && ((HashMap<String, Object>) jsonData.get("user")).get("email") != null
				&& ((HashMap<String, Object>) jsonData.get("creditCard")).get("number") != null){
			User user = userRepository.findByEmail("Bauer@pizzabyte.com");
			if(user == null){
				user = new User(((HashMap<String, Object>) jsonData.get("user")).get("email").toString());
				userRepository.save(user);
			}
			CreditCard creditCard = creditCardRepository.findByNumber(((HashMap<String, Object>) jsonData.get("creditCard")).get("number").toString());
			if(creditCard == null){
				String number = ((HashMap<String, Object>) jsonData.get("creditCard")).get("number").toString();
				String expiration = ((HashMap<String, Object>) jsonData.get("creditCard")).get("expiration").toString();
				String code = ((HashMap<String, Object>) jsonData.get("creditCard")).get("expiration").toString();
				if(number != null && expiration != null && code != null)
					creditCard = new CreditCard(number, new Date(), Integer.parseInt(code));
				else
					return null;
			}
			order.setCreditCard(creditCard);
			order.setUser(user);
			ArrayList<Pizza> pizzaList = parsePizza((ArrayList<HashMap<String, Object>>)jsonData.get("pizzaList"));
			if(pizzaList != null){
				order.setPizzaList(pizzaList);
				ordersRepository.save(order);
			}
			else
				return null;
		}
		else{
			return null;
		}
		/*
		 * A thread can be created here where in background another rest call to email 
		 * services(SendGrid is one of the email service or we can purchase our own SMTP servers to have this )
		 *  can be made to sent user information about order
		 *  If a third party server is used then to implements steps can be taken are 
		 *  1) Include dependecies in pox.xml which are required for services
		 *  2)Write a Java class for configurig the service which might need to add a SSH key or email service username and 
		 *  password
		 *  2)Follow standards for sending emails most of them would be 
		 * 
		 *  EmailService service = new EMailService();
		 *  service.addrecipient();
		 *  service.addBoyd();
		 *  service.send()
		 *  
		 *  
		 * 
		 */
		return order;
	}
	

	/*
	 * @description: This method takes json pizzalist and creates Pizza objects using Pizzz POJO 
	 * class and PizzaRepo
	 * @Params this accepts json formatted data which would be list of pizza 
	 * @Returns This returns List of Pizza instances
	 */
	public ArrayList<Pizza> parsePizza(ArrayList<HashMap<String, Object>> pizzaList){
		ArrayList<Pizza> result = new ArrayList<>();
		for(int i=0;i<pizzaList.size();i++){
			HashMap<String, Object> temp = pizzaList.get(i);
			if(!temp.get("name").toString().equals("Meat Special") && !temp.get("name").toString().equals("Cheese Lovers")){
				result.add(pizzaRepository.findByName(temp.get("name").toString()));
			}
			else if(temp.get("name").toString().equals("custom pizza")){
				ArrayList<Item> items = parseItems(((ArrayList<HashMap<String, Object>>)temp.get("items")));
				float price = 0;
				if(items == null)
					return null;
				else{
					price = 0;
					for(int j=0;j<items.size();j++){
						price += items.get(i).getPrice();
					}
				}
				Pizza pizza = new Pizza("Custom Pizza", price);
				pizza.setItems(items);
				result.add(pizza);
			}
		}
		return result;
	}
	
	/*
	 * @Description: This method is used to save items in a pizza
	 * @Params items list in form of items 
	 * @Returns ArrayList of item
	 */
	public ArrayList<Item> parseItems(ArrayList<HashMap<String, Object>> itemsList){
		ArrayList<Item> result = new ArrayList<>();
		for(int i=0;i<itemsList.size();i++){
			HashMap<String, Object> temp = itemsList.get(i);
			if(temp.get("type").equals("Veggies") || temp.get("type").equals("Cheese") || temp.get("type").equals("Bread")){
				Item item = itemRepository.findByName(temp.get("name").toString());
				if(item != null)
					result.add(item);
				else
					return null;
			}
			else
				return null;
		}
		return result;
	}
}
