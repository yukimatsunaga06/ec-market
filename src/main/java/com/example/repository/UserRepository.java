package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;


@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate template;
	
	private final RowMapper<User> USER_ROW_MAPPER = new BeanPropertyRowMapper<>(User.class);
	
	private final String TABLE_NAME = "users_table";
	
	public void insert(User user) {
		String sql = "INSERT INTO " + TABLE_NAME
				+ " (name, email, password, zipcode, address, telephone) values(:name, :email, :password, :zipcode, :address, :telephone);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);

		template.update(sql, param);
	}
}
