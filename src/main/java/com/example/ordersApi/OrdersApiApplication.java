package com.example.ordersApi;

import com.example.ordersApi.models.Client;
import com.example.ordersApi.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.util.stream.StreamSupport.stream;

@SpringBootApplication
public class OrdersApiApplication implements CommandLineRunner {
@Autowired
	private ClientRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(OrdersApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ArrayList<Client> clients = new ArrayList<Client>(){
			{

				add(new Client("234", "Clietn1", "", LocalDate.now(), "address x", "Tunis", 124654L, "+43546436", "+43546436", "34235235", "cdf@gmail.com"));

						add(new Client("123", "Clietn2", "", LocalDate.now(), "address x", "Tunis", 124654L, "+43546436", "+43546436", "34235235", "lkio@gmail.com"));

			}
		};





		clients.forEach(client->this.repo.save(client));

		};
	}
