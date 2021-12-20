package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.AutoCompleteRepository;

/** 商品検索フォームのオートコンプリート用コントローラ. */
@RestController
@RequestMapping("/market")
public class AutoCompleteApiController {

	@Autowired
	private AutoCompleteRepository autoCompleteRepository;

	/** 全商品名をオートコンプリートに渡す. */
	@GetMapping("/search-item-by-name")
	public List<String> autoCompleteList() {
		List<String> allNames = autoCompleteRepository.getAllNames();
		return allNames;
	}
}