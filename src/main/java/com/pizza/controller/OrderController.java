package com.pizza.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizza.model.Orders;
import com.pizza.services.OrderService;

@RestController
public class OrderController {
	
	@RequestMapping(value = "/orders", method=RequestMethod.PUT)
	public ResponseEntity<String> createOrder(HttpServletRequest request) throws Exception{
		Orders order = null;
		OrderService orderService = new OrderService();
		HashMap<String, Object> jsonData = parseJson(request.getInputStream());
		order = orderService.createService(jsonData);
		if(order == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad/invalid json data received");
		else
			return ResponseEntity.status(HttpStatus.OK).body(order.toString());
	}
	
	
	public HashMap<String, Object> parseJson(InputStream request) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(request));
        String read = "";
        StringBuilder sb = new StringBuilder();
        while((read=br.readLine()) != null) {
            sb.append(read);   
        }
        HashMap<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        map = mapper.readValue(sb.toString(), HashMap.class);
        return map;
	}

}
