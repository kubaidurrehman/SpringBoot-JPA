package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.UserBean;
import com.example.demo.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Customer")

public class CustomerController {
	
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService= customerService;
	}
	

	@GetMapping("/All")
	public List<UserBean> findAll() {
		return customerService.findall();
	}

	@GetMapping("/getById/{id}")
	public UserBean findById(@PathVariable int id) {
		return customerService.findById(id);
	}

	@PostMapping("/Save")
	public UserBean save(@RequestBody UserBean user) {
		return customerService.save(user);
	}

	@PutMapping("/put/{id}")
	public UserBean update(@RequestBody UserBean userDetails, @PathVariable int id) {
		
		UserBean user = customerService.findById(id);
		if (user != null) {
			user.setName(userDetails.getName());
			user.setBalance(userDetails.getBalance());
			return customerService.save(user);
		}
		return null;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		customerService.deleteUser(id);
		return;
	}
}
