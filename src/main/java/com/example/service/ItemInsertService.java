package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

@Service
@Transactional
public class ItemInsertService {
	@Autowired
	private ItemRepository repository;
	/**
	 * 新しいIDの取得
	 * @return
	 */
	public Integer getId() {
		return repository.getPrimaryId();
	}
	
	/**
	 * 商品の登録
	 * @param item
	 */
	public void insert(Item item) {
		repository.insert(item);
	}
}
