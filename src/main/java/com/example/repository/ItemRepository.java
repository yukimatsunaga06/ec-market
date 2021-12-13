package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;

@Repository
public class ItemRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final RowMapper<Item> ITEM_ROW_MAPPER = new BeanPropertyRowMapper<>(Item.class);

	private final String TABLE_NAME = "items_table";
	
	public List<Item> findAll() {
		String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY price DESC"; 
		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
		return itemList;
	}
	
	public List<Item> findAllSort(String sortName, boolean isDesc) {
		String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + sortName;
		
		if (isDesc == true) { // DESCで検索する場合
			sql += " DESC";
		}
		
		SqlParameterSource param = new MapSqlParameterSource();
		List<Item> itemList = template.query(sql, param ,ITEM_ROW_MAPPER);
		return itemList;
	}

	
	public Item findById(Integer id) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Item item = template.queryForObject(sql, param, ITEM_ROW_MAPPER);

		return item;
	}

	public List<Item> findByNameAndSort(String name, String sortName, boolean isDesc) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name like :name ORDER BY " + sortName;

		if (isDesc == true) { // DESCで検索する場合
			sql += " DESC";
		}
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");

		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);


		return itemList;
	}
}

