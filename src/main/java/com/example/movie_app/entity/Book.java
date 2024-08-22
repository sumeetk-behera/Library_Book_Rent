package com.example.movie_app.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bookName;
	private String author;
	private String publishedBy;
	private String publishedDate;
	
	private String description;
	private Integer price_per_hour;
	private boolean rentedOrNot;
	
	@OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
	private RentBookOrder rentBookOrder;

}
