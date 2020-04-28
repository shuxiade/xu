package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Good {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
}
