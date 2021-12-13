package com.example.form;

/**
 * @author yukimatsunaga
 *
 */
public class SearchItemByNameForm {

	private String searchingName;
	
	private Integer category;
	
	public SearchItemByNameForm(String searchingName, Integer category) {
		this.searchingName = searchingName;
		this.category = category;
	}


	public String getSearchingName() {
		return searchingName;
	}

	public void setSearchingName(String searchingName) {
		this.searchingName = searchingName;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SearchItemByNameForm [searchingName=" + searchingName + ", category=" + category + "]";
	}
	

}
