package com.example.demo.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Bean.UserBean;

@Repository
public interface CsutomerRepository extends JpaRepository<UserBean, Integer> {

}
