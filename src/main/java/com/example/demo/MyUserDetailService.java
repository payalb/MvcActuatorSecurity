package com.example.demo;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDetail;
@Service
public class MyUserDetailService implements UserDetailsService, UserDetailsPasswordService {

	@Autowired
	UserRepository rep;
	@Autowired PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetail user = rep.findById(username).get();
		System.out.println(user);
		if (user == null) {
			throw new RuntimeException("Invalid credentials! Username not correct.");
		}
		user.getAuthorities().stream().map(x-> new SimpleGrantedAuthority(x)).forEach(System.out::println);
		return new User(user.getUsername(), user.getPassword(),
				user.getAuthorities().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
	}

	@Override
	public UserDetails updatePassword(UserDetails user, String newPassword) {
		UserDetail user1 = rep.findById(user.getUsername()).get();
		System.out.println("op:"+user.getPassword());
		System.out.println("np: "+newPassword);
		user1.setPassword(newPassword);
		 rep.save(user1);
		 return this.loadUserByUsername(user.getUsername());
		
	}

}
