
/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import mongodb.JavaSimpleExample;
import mongodb.controllers.CustomerController;
import mongodb.models.Customer;
import mongodb.repositories.CustomerRepository;
import net.sf.jasperreports.engine.JRException;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import javax.sql.DataSource;
import javax.validation.Valid;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

@CrossOrigin
@Controller
@SpringBootApplication
public class Main {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Autowired
	private DataSource dataSource;
	
	@Autowired
    CustomerRepository customerRepository;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
		SpringApplication.run(CustomerController.class, args);
		//SpringApplication.run(HelloWorldController.class, args);

	}

	@RequestMapping("/")
	String index() {
		return "index";
	}

	@GetMapping("/hello-world")
	@ResponseBody
	public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}


	@PostMapping("/adduser")
	@ResponseBody
    public User create(@RequestBody User user){
		System.out.println("create user called");
        return user;
		//return userService.create(user);
    }
	
	@PostMapping("/printuser")
	@ResponseBody
    public ResponseEntity<byte[]> print(@RequestBody User user) throws JRException, IOException{
		System.out.println("print user called");
		Map<String, Object> inputParam = new HashMap<String, Object>();
		Greeting temp = new Greeting(22L, "contenuto del greeting");
		inputParam.put("greeting", temp);
		byte[] contents = JasperHelper.printPdf(inputParam);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
		System.out.println("end print user");
		return response;
    }
	
	@PostMapping("/printCharacterSheet")
	@ResponseBody
    public ResponseEntity<byte[]> printCharacterSheet(@RequestBody CharacterSheet characterSheet) throws JRException, IOException{
		System.out.println("print characterSheet called");
		characterSheet.getStrength()[1] = (characterSheet.getStrength()[0] - 10)/2;
		characterSheet.getDexterity()[1] = (characterSheet.getDexterity()[0] - 10)/2;
		characterSheet.getConstitution()[1] = (characterSheet.getConstitution()[0] - 10)/2;
		characterSheet.getIntelligence()[1] = (characterSheet.getIntelligence()[0] - 10)/2;
		characterSheet.getWisdom()[1] = (characterSheet.getWisdom()[0] - 10)/2;
		characterSheet.getCharisma()[1] = (characterSheet.getCharisma()[0] - 10)/2;
		Map<String, Object> inputParam = new HashMap<String, Object>();
		inputParam.put("characterSheet", characterSheet);
		byte[] contents = JasperHelper.printPdf("CharacterSheet.jrxml", inputParam);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "characterSheet.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
		System.out.println("end print characterSheet");
		return response;
    }
    
	@GetMapping("/getpdf")
	@ResponseBody
	public ResponseEntity<byte[]> getPDF(/* @RequestBody String json */) throws net.sf.jasperreports.engine.JRException, java.io.IOException{


		// retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
		//byte[] contents = "Any String you want".getBytes();
		Map<String, Object> inputParam = new HashMap<String, Object>();
		Greeting temp = new Greeting(22L, "contenuto del greeting");
		inputParam.put("greeting", temp);
		byte[] contents = JasperHelper.printPdf(inputParam);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
		return response;
	}

	@PostMapping("/getpdf")
	@ResponseBody
	public ResponseEntity<byte[]> getPDF( @RequestBody String json ) throws net.sf.jasperreports.engine.JRException, java.io.IOException{


		// retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
		//byte[] contents = "Any String you want".getBytes();
		byte[] contents = JasperHelper.printPdf();


		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
		return response;
	}

	@RequestMapping("/db")
	String db(Map<String, Object> model) {
		
		if(JavaSimpleExample.isEmpty()) {
			try {
				JavaSimpleExample.create();
			} catch (UnknownHostException e) {
				e.printStackTrace();
				model.put("message", e.getMessage());
				return "error";
			}
		}
		List<Document> documentList = JavaSimpleExample.getDocumentList();
		model.put("records", documentList);
		return "db";
//		try (Connection connection = dataSource.getConnection()) {
//			Statement stmt = connection.createStatement();
//			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
//			stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//			ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//
//			ArrayList<String> output = new ArrayList<String>();
//			while (rs.next()) {
//				output.add("Read from DB: " + rs.getTimestamp("tick"));
//			}
//
//			model.put("records", output);
//			return "db";
//		} catch (Exception e) {
//			model.put("message", e.getMessage());
//			return "error";
//		}
	}
	
	
	@RequestMapping("/mongodb")
	String mongoDB(Map<String, Object> model) {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		List<Customer> customerList = customerRepository.findAll(sortByCreatedAtDesc);
		if(customerList.isEmpty()) {
			Customer customer1 = new Customer("first name", "first surname");
			customerRepository.save(customer1);
			Customer customer2 = new Customer("second name", "second surname");
			customerRepository.save(customer2);
		}
		customerList = customerRepository.findAll(sortByCreatedAtDesc);
		model.put("records", customerList);
		return "mongodb";
	}

	@Bean
	public DataSource dataSource() throws SQLException {
		if (dbUrl == null || dbUrl.isEmpty()) {
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			return new HikariDataSource(config);
		}
	}

}
