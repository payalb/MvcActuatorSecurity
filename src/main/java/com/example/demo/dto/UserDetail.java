package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {
@Id
	private String username;
	private String password;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> authorities= new ArrayList<>();
	private boolean enabled=true;
	
}
