package com.te.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.te.Library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("select b from Book b where b.bookName like %:searchString% or b.author like %:searchString%")
	List<Book> findBySearchString(String searchString);
}
