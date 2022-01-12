package com.example.ordersApi;

import com.example.ordersApi.models.Categorie;
import com.example.ordersApi.models.Client;
import com.example.ordersApi.models.Produit;
import com.example.ordersApi.repositories.CategoryRepo;
import com.example.ordersApi.repositories.ClientRepo;
import com.example.ordersApi.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.StreamSupport.stream;

@SpringBootApplication
public class OrdersApiApplication implements CommandLineRunner {
@Autowired
	private ClientRepo clientRepo;
@Autowired
	private ProduitRepo produitRepo;
@Autowired
	private CategoryRepo categoryRepo;

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

		ArrayList<Produit> produuits = new ArrayList<Produit>(){
			{
var cat1=new Categorie();
var cat2=new Categorie();
categoryRepo.saveAll(List.of(cat1,cat2));
				add(new Produit(123L,"code1245","Mark1","Model1","",new BigDecimal(10),124L,cat1, Set.of()));
				add(new Produit(123L,"code4256","Mark2","Model2","",new BigDecimal(120),124L,cat2, Set.of()));


			}
		};

		clients.forEach(client->this.clientRepo.save(client));
		produuits.forEach(produit->this.produitRepo.save(produit));

		};
	}
