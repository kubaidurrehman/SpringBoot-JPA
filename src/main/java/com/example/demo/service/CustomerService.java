package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bean.UserBean;
import com.example.demo.Persistance.CsutomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CsutomerRepository repo;

	public List<UserBean> findall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public UserBean findById(long id) {
		return repo.findById((int) id).orElse(null);
	}

	public UserBean save(UserBean user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	public void deleteUser(int id) {
		repo.deleteById(id);
		return;
	}

}
