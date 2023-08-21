package sspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//For making controller to any java class we can use @Controller annotation 
@Controller
public class HomeController {

	@RequestMapping("/contact")
	public String home() {
		return "Contact";
	}

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@RequestParam("firstname") String Username, @RequestParam("address") String Useradrs,
			@RequestParam("subject") String UserMsg) {
		try {
			System.out.println("Your data Stored into Database.............................");
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/userdata", "postgres",
					"#Animesh01");
			Statement smt = con.createStatement();
			System.out.println("User name is " + Username + " ,Address is " + Useradrs + " ans Query is " + UserMsg);
			ResultSet Insert_values = smt.executeQuery("INSERT INTO data (user_name,user_add,user_msg) VALUES('Animesh','Lucknow','Hello')");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("hiiii");
		}

		return "success";
	}
}
