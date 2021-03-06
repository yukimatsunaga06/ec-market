package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
		System.out.println(name);
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name LIKE :name ORDER BY " + sortName;

		if (isDesc == true) { // DESCで検索する場合
			sql += " DESC";
		}
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");

		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);


		return itemList;
	}
	
	/**
	 * 最大のIDを取得
	 * @return
	 */
	public Integer getPrimaryId() {
		try {
			Integer maxId = template.queryForObject("SELECT MAX(id) FROM items_table;", new MapSqlParameterSource(),
					Integer.class);
			return maxId + 1;
		} catch (DataAccessException e) {
			// データが存在しない場合
			return 1;
		}
	}
	
	/**
	 * 商品詳細のSQLを発行
	 * 
	 * @param id 商品ID
	 * @return Item情報１件
	 */
	public Item showItemDetail(Integer id) {
		String showItemDetailSql = "SELECT * FROM items_table WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Item item = template.queryForObject(showItemDetailSql, param, ITEM_ROW_MAPPER);
		return item;
	}
	
	/**
	 * 商品の登録
	 * @param item
	 */
	public void insert(Item item) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		String sql = "INSERT INTO items_table(id, name, description, price, image_path, category)"
				+ " VALUES (:id, :name, :description, :price, :imagePath, :category);";
		template.update(sql, param);
	}
	
	public List<Item> findByName(String name) {
		String sql = "SELECT * FROM items_table WHERE name LIKE :name ORDER BY price";
		// SELECT * FROM items WHERE name like '%パーカー%' ORDER BY price_m DESC;

		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");

		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);


		return itemList;
	}

}

