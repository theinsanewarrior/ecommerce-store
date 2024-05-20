package com.store.models;

import javax.persistence.*;

@Entity
public class ProductCategory {
	@Id
	@GeneratedValue(generator = "cat_seq")
	@SequenceGenerator(name = "cat_seq",sequenceName = "CAT_SEQ",initialValue = 111)
	private int cat_id;
	private String pcategory;
	private String description;
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getCategory() {
		return pcategory;
	}
	public void setCategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
