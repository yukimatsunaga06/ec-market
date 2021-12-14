package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Item;
import com.example.form.ItemForm;
import com.example.service.ItemInsertService;

@Controller
@RequestMapping("")
public class ItemInsertController {

	@Autowired
	private ItemInsertService service;
	
	@ModelAttribute
	public ItemForm setItemForm(){
		return new ItemForm();
	}
	
	@RequestMapping("/toInsertItem")
	public String toInsertItem() {
		return "item_insert";
	}
	
	@RequestMapping("/insertItem")
	public String insertItem(@Validated ItemForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "item_insert";
		}
	
	//	画像の名前を取得・ファイルに保存
	MultipartFile multiFile = form.getImagePath();
	String fileName = multiFile.getOriginalFilename();
	
	File filepath = new File("src/main/resources/static/img/"+fileName);
	try {
		byte[] bytes = multiFile.getBytes();
		FileOutputStream stream = new FileOutputStream(filepath.toString());
		stream.write(bytes);
		stream.close();
	}catch(Exception e) {
		e.printStackTrace();
	}

		Item item = new Item();
		BeanUtils.copyProperties(form, item);
		item.setPrice(form.getIntPrice());
		item.setCategory(form.getCategory());
		item.setImagePath(fileName);
		item.setId(service.getId());
		service.insert(item);
		return "redirect:/market";
	}
}
