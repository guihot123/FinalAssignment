package com.example.jbe092023.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Table_categorizes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer id;
	
	@Column(name = "col_categoryname", nullable = false)
	private String categoryname;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Product> products =new ArrayList<Product>();

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getCategoryId() {
		return id;
	}

	public void setCategoryId(Integer categoryId) {
		this.id = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryname() {
		return categoryname;
	}
	
	
}
