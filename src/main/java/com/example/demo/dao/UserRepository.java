package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.UserDetail;

public interface UserRepository extends CrudRepository<UserDetail, String>{

}
