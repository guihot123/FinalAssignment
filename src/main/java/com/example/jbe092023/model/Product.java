package com.example.jbe092023.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Table_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;
	
	@Column(name = "col_productname")
	private String productname;
	
	@ManyToOne
	@JoinColumn(name="categoryId",referencedColumnName = "category_id",nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<VariantProduct> variantproducts = new ArrayList<VariantProduct>();

	public Integer getProductId() {
		return id;
	}

	public void setProductId(Integer productId) {
		this.id = productId;
	}

	public String getName() {
		return productname;
	}

	public void setName(String name) {
		this.productname = name;
	}

	public Category getCategories() {
		return category;
	}

	public void setCategories(Category categories) {
		this.category = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	
}
