package com.lanou3g.springboot_demo.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Man implements Serializable {
	private String name;
	private Integer age;

	public Man(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}
