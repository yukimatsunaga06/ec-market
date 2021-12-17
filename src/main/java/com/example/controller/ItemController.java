package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.form.SearchItemByNameForm;
import com.example.service.ItemService;

@Controller
@RequestMapping("/market")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@ModelAttribute
	public SearchItemByNameForm setUpForm() {
		return new SearchItemByNameForm();
	}

	@RequestMapping("")
	public String showList(Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList", itemList);
		return "market_list";
	}
	

	@RequestMapping("/search-item-by-name")
	public String searchItemByName(SearchItemByNameForm form, Model model) {
		System.out.println("検索ワード：" + form.getSearchingName());
		
		List<Item> itemList = null;

		itemList = itemService.searchByName(form.getSearchingName());
		
//		List<Item> itemList = itemService.searchByNameAndSort(form.getSearchingName());
		if (itemList.size() == 0) {
			itemList = itemService.findAll();
			model.addAttribute("searchMessage", "該当する商品がありません");
		}

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
