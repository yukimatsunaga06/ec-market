package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ItemService;

@Controller
@RequestMapping("/market")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping("")
	public String showList(Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList", itemList);
		return "market_list";
	}
	
	/**
	 * 商品詳細画面を表示
	 * 
	 * @param id　商品ID
	 * @param model リクエストスコープ
	 * @return item/detail.html
	 */
	@RequestMapping("/showDetail")
	public String showItemDetail(String id, Model model) {
		
		
		//商品詳細を表示させる
		Item item = itemService.showItemDetail(Integer.parseInt(id));
		model.addAttribute("item", item);

		return "item_detail";
	}
}
