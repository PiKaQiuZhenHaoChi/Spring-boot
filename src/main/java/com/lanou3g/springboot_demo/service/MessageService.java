package com.lanou3g.springboot_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> selectAllMessage() {
		return jdbcTemplate.query("select * from message", new ColumnMapRowMapper());
	}

}
