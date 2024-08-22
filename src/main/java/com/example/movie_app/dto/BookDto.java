package com.example.movie_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

	private Integer id;
	
	private String bookName;
	private String author;
	private String publishedBy;
	private String publishedDate;
	
	private String description;
	private Integer price_per_hour;
	
}
