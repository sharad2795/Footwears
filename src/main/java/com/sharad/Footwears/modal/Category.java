package com.sharad.Footwears.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Component;


@Entity
@Table(name="category1")//if the class name and table name is different
@Component               //if want to cerate instance of Class Category  - category
public class Category 
{
	//add simple properties - same as Category table
		//generate getter/setter methods
		
		@Id
		@Size(min=2,max=20)
		private String id;
		@Size(min=2,max=30)
		private String name;
		@Size(min=5,max=500)
		private String description;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
}
