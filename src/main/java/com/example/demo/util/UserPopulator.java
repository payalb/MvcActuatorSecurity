package com.example.demo.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDetail;

@Component
//@Profile("test")
public class UserPopulator implements CommandLineRunner {

	@Autowired UserRepository rep;
	@Override
	public void run(String... args) throws Exception {
		rep.save(new UserDetail("payal","{MD5}64d8a47c30f84958c2cc2181e9382f35", Arrays.asList("ROLE_USER","ROLE_ADMIN"),true));
		rep.save(new UserDetail("ruchi","{bcrypt}$2a$11$OhI1kk6nWuoSBAfeIcsttezw2jjGul9fIR1h14KYcJ/3dSZC.Wn.q", Arrays.asList("USER"),true));
	}

}
