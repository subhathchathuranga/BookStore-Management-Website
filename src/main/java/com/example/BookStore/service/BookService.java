package com.example.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.entity.Book;
import com.example.BookStore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository BookRepository;
	
	public void SaveBook(Book book) {
		BookRepository.save(book);
	}
	
	  // Get all entities
    public List<Book> getInfo() {
        return BookRepository.findAll();
    }
    
    public Book showEdit(Long id) {
    	return BookRepository.findById(id).orElse(null);
    }
    
    // Delete entity
    public void deleteInfo(Long id) {
    	BookRepository.deleteById(id);
    }

}
